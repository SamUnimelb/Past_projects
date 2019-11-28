
class SentenceUnit:
    def __init__(self, sentence, weight, label):
        self.sentence = sentence
        self.weight = weight
        self.label = label

    def __eq__(self, other):
        return self.weight == other.weight

    def __gt__(self, other):
        return self.weight > other.weight

    def __lt__(self, other):
        return self.weight < other.weight

#Get the best threshold for which both precision and accuracy are high enough.
class DevTrainModel:

    #Get extreme values for a sentence to be "yes" or "no"
    #namely, if higher than highNo, the attribute must be "yes"
    #Meanwhile, if lower than lowYes, the attribute must be "no"
    def getExtremeValues(self):
        self.total = self.positive = self.negative = 0
        self.sentenceData = []
        classifyRetFile = open("ClassificationResults.txt", "r")
        self.highNo = 0.0
        data = classifyRetFile.readline().split("\t")
        self.lowYes = data[-3]

        for eachLine in classifyRetFile:
            self.total += 1
            data = eachLine.split("\t")
            sentence = eachLine[0 : -3]
            weight = float(data[-3])
            label = data[-2]

            sentenceUnit = SentenceUnit(sentence, weight, label)

            #sentence data is sorted in this case.
            self.sentenceData.append(sentenceUnit)

            #print sentence, label, weight

            if label == 'Y':
                self.positive += 1
                if weight < self.lowYes: self.lowYes = weight

            elif label == 'N':
                self.negative += 1
                if weight > self.highNo: self.highNo = weight

        classifyRetFile.close()

        """"
        print "Number of yes labels in total:", self.positive
        print "Number of no labels in total:", self.negative
        print "Number of labels in total:", self.total
        print "For a sentence to be determined must as yes, weight must higher than", self.highNo
        print "For a sentence to be determined must as no, weight must lower than", self.lowYes
        """

        return (self.highNo, self.lowYes)

    """
        Input: Training goals as precision and specificity,
        Output: possible range of threshold (as hiper plane) and accuracy
    """
    def trainDevThreshold(self, expectedPrecision, expectedSpecificity):

        self.threshold = 0.0
        self.getExtremeValues()
        #Lower than this value, prediction to be no
        noThreshold = self.highNo
        #Higher than this value, prediction to be yes
        yesThreshold = self.lowYes

        allowedFalseNegative = int(self.positive * (1.0 - expectedPrecision))
        #print "Allowed false negative:", allowedFalseNegative
        allowedFalsePositive = int(self.negative * (1.0 - expectedSpecificity))
        #print "Allowed false positive:", allowedFalsePositive

        self.actualFalseNegative = self.actualFalsePositive = 0

        while(self.actualFalseNegative <= allowedFalseNegative):
            self.actualFalseNegative = self.getNumFalseNeg(yesThreshold)
            yesThreshold = self.getNextHigherYesThreshold(yesThreshold)

        while(self.actualFalsePositive <= allowedFalsePositive):
            self.actualFalsePositive = self.getNumFalsePos(noThreshold)
            noThreshold = self.getNextLowerNoThreshold(noThreshold)

        #print "Final suggested threashold predicted as yes:", yesThreshold
        #print "Final suggested threashold predicted as no:", noThreshold
        #Ideal condition: higher than this must be yes, lower than this must be no, very clear.
        if yesThreshold >= noThreshold:
            #Though noThreashold able to detect ADR is more important
            #yesThreashold dominates accuracy.
            self.threshold = yesThreshold
        else:
            self.threshold = (yesThreshold + noThreshold) * 1.0 / 2.0

        #print "Final suggested threashold:", self.threshold
        return (yesThreshold, noThreshold)

    """
        Given threashold judged as no,
        return number of actual yes predicted as no.
    """
    def getNumFalseNeg(self, yesThreshold):
        falseNegVal = 0
        for eachSentence in self.sentenceData:
            if eachSentence.weight < yesThreshold and eachSentence.label == 'Y':
                falseNegVal += 1

        return falseNegVal

    def getNextHigherYesThreshold(self, yesThreshold):
        for eachSentence in reversed(self.sentenceData):
            if eachSentence.weight > yesThreshold and eachSentence.label == 'Y':
                yesThreshold = eachSentence.weight
                break

        return yesThreshold

    def getNumFalsePos(self, noThreshold):
        falsePosVal = 0
        for eachSentence in self.sentenceData:
            if eachSentence.weight > noThreshold and eachSentence.label == 'N':
                falsePosVal += 1

        return falsePosVal

    def getNextLowerNoThreshold(self, noThreshold):
        for eachSentence in self.sentenceData:
            if eachSentence.weight < noThreshold and eachSentence.label == 'N':
                noThreshold = eachSentence.weight
                break

        return noThreshold

    def getAccuracy(self, recall, specification):

        self.trainDevThreshold(recall, specification)
        falsePositive = self.falseNegative = 0

        for eachSent in self.sentenceData:
            if eachSent.weight >= self.threshold and eachSent.label == 'N':
                falsePositive += 1
            elif eachSent.weight < self.threshold and eachSent.label == 'Y':
                self.falseNegative += 1

        correctPredicted = self.total - falsePositive - self.falseNegative
        #print "False positive, False negative:", falsePositive, self.falseNegative
        return correctPredicted * 1.0 / self.total

    def trainAccurateModel(self):

        specification = 0.99
        possibleAccuracies = {}

        while specification >= 0.75:
            recall = 0.99
            while recall >= 0.58:
                accuracy = self.getAccuracy(recall, specification)
                #print "Accuracy and expected precision, specification: ", accuracy, precision, specification
                possibleAccuracies[(recall, specification)] = accuracy
                recall -= 0.01
            specification -= 0.01

        #print sorted(possibleAccuracies.keys())
        #Highest accuracy, precision and most proper specification can be achieved:
        highestAccuracy = highestPrecision = mostProperSpecification = 0.0

        for eachKey in sorted(possibleAccuracies, key=possibleAccuracies.get, reverse=True):
            recall, specification = eachKey
            accuracy = possibleAccuracies[eachKey]

            if recall > highestPrecision and accuracy >= highestAccuracy:
                highestPrecision = recall
                highestAccuracy = accuracy
                mostProperSpecification = specification


        print "Final accuracy:", highestAccuracy
        print "Final recall:", highestPrecision
        print "Final specification:", mostProperSpecification
        self.trainDevThreshold(highestPrecision, mostProperSpecification)
        #print "Threashold under this condition:", self.threshold

        return self.threshold

    def trainPreciseModel(self):
        recall = 0.99
        possibleFalseNegatives = {}

        while recall >= 0.75:
            specification = 0.99
            while specification >= 0.80:
                accuracy = self.getAccuracy(recall, specification)
                #print "Actual accuracy and expected precision, specification: ", accuracy, precision, specification
                possibleFalseNegatives[(recall, accuracy, specification)] = self.falseNegative
                specification -= 0.01
            recall -= 0.01

        # print sorted(possibleAccuracies.keys())
        # Highest accuracy, precision and most proper specification can be achieved:
        highestAccuracy = highestPrecision = mostProperSpecification = 0.0
        lowestFalseNegative = 100

        for eachKey in sorted(possibleFalseNegatives, key=possibleFalseNegatives.get):
            recall, accuracy, specification = eachKey
            falseNegative = possibleFalseNegatives[eachKey]

            if accuracy > highestAccuracy and falseNegative <= lowestFalseNegative:
                highestAccuracy = accuracy
                highestPrecision = recall
                lowestFalseNegative = falseNegative
                mostProperSpecification = specification

        """
        print "Final actual accuracy:", highestAccuracy
        print "Final expected precision:", highestPrecision
        print "Final expected specification:", mostProperSpecification
        print "Lowest expected false negative under this goal:", lowestFalseNegative
        """
        self.trainDevThreshold(highestPrecision, mostProperSpecification)
        #print "Threashold under this condition:", self.threshold
        return self.threshold

    #Both accuracy and precision shall be high:
    def trainBalancedModel(self):
        recall = 0.99
        actualTruePositives = {}

        while recall >= 0.80:
            specification = 0.99
            while specification >= 0.80:
                accuracy = self.getAccuracy(recall, specification)
                #print "Actual accuracy and expected recall, specification: ", accuracy, recall, specification
                actualTruePositives[(recall, accuracy, specification)] = self.positive - self.falseNegative

                specification -= 0.01
            recall -= 0.01

        # print sorted(possibleAccuracies.keys())
        # Highest accuracy, recall and most proper specification can be achieved:
        highestAccuracy = highestActualPrecision = mostProperSpecification = 0.0

        for eachKey in sorted(actualTruePositives, key=actualTruePositives.get):
            recall, accuracy, specification = eachKey
            truePositives = actualTruePositives[eachKey]
            actualPrecision = truePositives * 1.0 / self.positive

            if accuracy + actualPrecision >= highestAccuracy + highestActualPrecision:
                highestAccuracy = accuracy
                highestActualPrecision = actualPrecision
                mostProperSpecification = specification

        """
        print "Final actual accuracy:", highestAccuracy
        print "Final actual recall:", highestActualPrecision
        print "Final expected specification:", mostProperSpecification
        """

        self.trainDevThreshold(highestActualPrecision, mostProperSpecification)
        print "Threashold under this condition:", self.threshold
        return self.threshold

trainer = DevTrainModel()
"""
print "Number of false negative under this threshold: ", trainer.getNumFalseNeg(22212.0)
print "Next higher yes threashold is:", trainer.getNextHigherYesThreshold(16140.0)
print "Number of false positive under this threshold: ", trainer.getNumFalsePos(22212.0)
print "Next lower no threashold is:", trainer.getNextLowerNoThreshold(22212.0)
"""

print trainer.trainAccurateModel()
print trainer.trainPreciseModel()
print trainer.trainBalancedModel()
import re

#Input: Sentences, output: each word in sentence as a list
def substractWords(sentence):
    word = re.compile("^[A-Za-z]+")
    wordList = []
    for eachWord in sentence.split():
        if word.match(eachWord):
            wordList.append(eachWord)

    words = []
    word = re.compile("^[A-Za-z]+$")
    for eachToken in wordList:
        eachSegment = re.split("\W+", eachToken)
        for eachWord in eachSegment:
            if word.match(eachWord) and len(eachWord) > 1:
                words.append(eachWord.lower())

    return words

#Input: Sentences, output: every possible binary term combination of the sentence
def substractBinTerms(tokens):
    binTerms = []
    size = len(tokens)
    for i in xrange(0, size):
        j = i + 1
        for j in xrange(j, size):
            binTerms.append(tokens[i] + " " + tokens[j])

    return binTerms

class Evaluator:

    def __init__(self, threashold):
        self.threashold = threashold
        self.formDictionary()
        self.total = self.truePos = self.falsePos = self.falseNeg = self.trueNeg = 0

    def predictTwittData(self):
        f = open("dev.txt", "r")
        predictResult = open("PredictRet" + str(self.threashold) + ".txt", "w")
        for eachLine in f:
            data = eachLine.split("\t")
            id = data[0]
            actualLabel = data[1]
            sentence = data[2]
            weight = self.weightForSentence(sentence)

            if weight >= self.threashold:
                prediction = 'Y'
            else:
                prediction = 'N'

            self.evaluatePrediction(actualLabel, prediction)
            #print id, sentence, actualLabel, prediction, weight
            predictResult.write(id + "\t" + sentence + "\t" + str(weight) + "\t" + actualLabel +
                                "\t" + prediction + "\n")

        f.close()
        predictResult.close()

    def formDictionary(self):
        self.termWeights = {}
        f = open("YesBinTokenFreqs.txt", "r")
        for eachLine in f:
            data = eachLine.split("\t")
            self.termWeights[data[0]] = float(data[2])
        f.close()

    def weightForSentence(self, sentence):

        terms = substractWords(sentence)
        length = len(terms)
        if length == 0:
            return 0.0
        terms = substractBinTerms(terms)
        weight = 0.0

        for eachTerm in terms:
            if eachTerm in self.termWeights.keys():
                weight += self.termWeights[eachTerm]

        return weight * 1.0 / length

    def evaluatePrediction(self, label, prediction):
        self.total += 1
        if label == 'Y':
            if prediction == 'Y': self.truePos += 1
            else: self.falseNeg += 1
        else:
            if prediction == 'Y': self.falsePos += 1
            else: self.trueNeg += 1

    def evaluateModel(self):
        print "Threashold: ", self.threashold
        print self.total, self.truePos, self.falseNeg, self.falsePos, self.trueNeg
        accuracy = (self.truePos + self.trueNeg) * 1.0 / self.total
        recall = self.truePos * 1.0 / (self.truePos + self.falseNeg)
        specificity = self.trueNeg * 1.0 / (self.trueNeg + self.falsePos)

        return (accuracy, recall, specificity)

evaluation = Evaluator(18875.3904762)
evaluation.predictTwittData()
print evaluation.evaluateModel()
print
print
evaluation1 = Evaluator(6144.56840278)
evaluation1.predictTwittData()
print evaluation1.evaluateModel()
print
print
evaluation2 = Evaluator(12845.8445626)
evaluation2.predictTwittData()
print evaluation2.evaluateModel()
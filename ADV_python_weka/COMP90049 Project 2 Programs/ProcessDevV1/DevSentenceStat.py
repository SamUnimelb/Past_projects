from BinTermStatistics import substractBinTerms

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

class DevSentenceProcessor:

    def __init__(self):
        self.termWeights = {}
        self.sentenceWeights = {}
        self.sentenceData = []
        self.errorSentenceData = []

    def getTermWeights(self):
        f = open("YesBinTokenFreqs.txt", "r")
        for eachLine in f:
            data = eachLine.split("\t")
            self.termWeights[data[0]] = float(data[2])
        f.close()

    def calculateSentences(self):
        self.getTermWeights()

        """
        dataFile = open("ProcessedDev.txt", "r")

        for eachLine in dataFile:
            data = eachLine.split("\t")
            sentence = eachLine[0 : -3]
            label = data[-2]
            weight = self.weightForSentence(data[0 : -2])

            sentenceUnit = SentenceUnit(sentence, weight, label)
            self.sentenceData.append(sentenceUnit)

        dataFile.close()
        self.__writeStatSentenceInfo()
        """

    def __writeStatSentenceInfo(self):
        retFile = open("ClassificationResults.txt", "w")
        self.sentenceData = list(sorted(self.sentenceData, reverse=True))

        for eachSentence in self.sentenceData:
            retFile.write(eachSentence.sentence + "\t" + str(eachSentence.weight)
                        + "\t"  + eachSentence.label + "\t\n")

        retFile.close()

    def weightForSentence(self, sentenceData):
        length = len(sentenceData)

        if length == 0:
            return 0.0

        terms = substractBinTerms(sentenceData)
        weight = 0.0

        for eachTerm in terms:
            if eachTerm in self.termWeights.keys():
                weight += self.termWeights[eachTerm]

        return weight * 1.0 / length

devSentProcessor = DevSentenceProcessor()
devSentProcessor.calculateSentences()
print devSentProcessor.weightForSentence(["Why", "does", "tapering", "down", "lamotrigine", "feel",
                                          "as", "yucky", "as", "stepping", "it", "up"])
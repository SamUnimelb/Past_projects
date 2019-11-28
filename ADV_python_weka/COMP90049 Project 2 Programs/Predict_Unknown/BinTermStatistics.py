#Input: Sentences, output: every possible binary term combination of the sentence
def substractBinTerms(tokens):
    binTerms = []
    size = len(tokens)
    for i in xrange(0, size):
        j = i + 1
        for j in xrange(j, size):
            binTerms.append(tokens[i] + " " + tokens[j])

    return binTerms

class BinTokenProcessor:

    def __init__(self):
        self.wordFreqInFile = {}
        self.accumulator = {}
        self.totalDocs = self.totalYesTokens = 0

    def statYesLabels(self):
        processedFile = open("ProcessedTrain.txt", "r")
        self.yesTokenFile = open("YesBinTokenFreqs.txt", "w")
        self.yesLabelSetences = open("YesLabelSentences.txt", "w")

        for eachLine in processedFile:
            data = eachLine.split("\t")
            label = data[-2]

            if label == 'Y':
                tokens = data[0: -2]
                terms = substractBinTerms(tokens)
                self. __statIDF(terms)

                for eachToken in tokens:
                    self.yesLabelSetences.write(eachToken + "\t")
                self.yesLabelSetences.write("\n")

            self.totalDocs += 1

        self.yesLabelSetences.close()
        self.__statTF()
        self.__writeResults()
        self.yesTokenFile.close()

    def __writeResults(self):
        for eachKey in sorted(self.accumulator, key=self.accumulator.get, reverse=True):
            self.totalYesTokens += 1
            self.yesTokenFile.write(eachKey + "\t" + str(self.wordFreqInFile[eachKey]) + "\t" \
                                + str(self.accumulator[eachKey]) + "\t\n")

        self.yesTokenFile.write("Total" + "\t" + str(self.totalDocs) + "\t" + str(self.totalYesTokens) + "\t\n")

    def __statIDF(self, terms):
        for eachTerm in set(terms):
            if eachTerm not in self.wordFreqInFile.keys():
                self.wordFreqInFile[eachTerm] = 1
            else:
                self.wordFreqInFile[eachTerm] += 1

    def __calculateAccu(self, term):
        if term not in self.accumulator:
            self.accumulator[term] = self.__applyAccuFormula(term)
        else:
            self.accumulator[term] += self.__applyAccuFormula(term)

    # In V0:
    # return math.log(1.0 + self.totalDocs * 1.0 / self.wordFreqInFile[term], 2)
    # But V1 makes more sense:
    def __applyAccuFormula(self, term):
        return self.totalDocs * 1.0 / self.wordFreqInFile[term]

    def __statTF(self):
        yesTokensFile = open("YesLabelSentences.txt", "r")
        for eachLine in yesTokensFile:
            data = eachLine.split("\t")
            tokens = data[0: -2]
            terms = substractBinTerms(tokens)

            for eachTerm in terms:
                self.__calculateAccu(eachTerm)

binTokenProcessor =  BinTokenProcessor()
binTokenProcessor.statYesLabels()
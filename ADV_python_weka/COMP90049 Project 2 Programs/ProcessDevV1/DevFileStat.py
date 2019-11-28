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

"""Testing instance
twitt = "@Sectioned_ @bipolarlife7 @BBCWomansHour ah yes, I'm starting to think my paroxetine turns panic attacks into fat."
print substractWords(twitt)
"""

def processDevFile():
    devFile = open("dev/dev.txt", "r")
    processedFile = open("dev_data/ProcessedDev.txt", "w")
    totalLabels = yesLabels = noLabels = 0

    for eachLine in devFile:
        totalLabels += 1
        info = eachLine.split("\t")
        twitt = info[2]
        string = ""
        attributes = substractWords(twitt)
        for eachAttribute in attributes:
            string += eachAttribute + "\t"
        label = info[1]
        if label == 'Y':
            yesLabels += 1
        else:
            noLabels += 1
        processedFile.write(string + label + "\t\n")

    devFile.close()
    processedFile.close()
    return (totalLabels, yesLabels, noLabels)

def processYesLabels():
    processedFile = open("dev_data/ProcessedDev.txt", "r")
    yesTokenFile = open("dev_data/YesTokenFreqs.txt", "w")

    yesTokens = {}
    wordFreqInFile = {}
    totalSentences = totalNumOfTokens = 0

    for eachLine in processedFile:

        tokens = eachLine.split("\t")
        sentenceLength = len(tokens)
        label =  tokens[sentenceLength - 2]
        context = []

        if label == 'Y':
            totalSentences += 1
            for i in xrange(0, sentenceLength - 2):
                context.append(tokens[i])
                if tokens[i] not in yesTokens.keys():
                    yesTokens[tokens[i]] = 1
                else:
                    yesTokens[tokens[i]] += 1

        context = set(context)
        for eachEle in context:
            if eachEle not in wordFreqInFile.keys():
                wordFreqInFile[eachEle] = 1
            else:
                wordFreqInFile[eachEle] += 1

    for eachKey in sorted(yesTokens, key = yesTokens.get, reverse = True):
        totalNumOfTokens += 1
        yesTokenFile.write(eachKey + "\t" + str(yesTokens[eachKey]) + "\t" + str(wordFreqInFile[eachKey]) + "\t\n")

    yesTokenFile.write("Total" + "\t" + str(totalNumOfTokens)  + "\t" + str(totalSentences) + "\t\n")
    processedFile.close()
    yesTokenFile.close()

def processNoLabels():
    processedFile = open("dev_data/ProcessedDev.txt", "r")
    noTokenFile = open("dev_data/NoTokenFreqs.txt", "w")

    noTokens = {}
    wordFreqInFile = {}
    totalSentences = totalNumOfTokens = 0

    for eachLine in processedFile:

        tokens = eachLine.split("\t")
        sentenceLength = len(tokens)
        label =  tokens[sentenceLength - 2]
        context = []

        if label == 'N':
            totalSentences += 1
            for i in xrange(0, sentenceLength - 2):
                context.append(tokens[i])
                if tokens[i] not in noTokens.keys():
                    noTokens[tokens[i]] = 1
                else:
                    noTokens[tokens[i]] += 1

        context = set(context)
        for eachEle in context:
            if eachEle not in wordFreqInFile.keys():
                wordFreqInFile[eachEle] = 1
            else:
                wordFreqInFile[eachEle] += 1

    for eachKey in sorted(noTokens, key = noTokens.get, reverse = True):
        totalNumOfTokens += 1
        noTokenFile.write(eachKey + "\t" + str(noTokens[eachKey]) + "\t" + str(wordFreqInFile[eachKey]) + "\t\n")

    noTokenFile.write("Total" + "\t" + str(totalNumOfTokens) + "\t" + str(totalSentences) + "\t\n")
    processedFile.close()
    noTokenFile.close()

print processDevFile()
processYesLabels()
processNoLabels()




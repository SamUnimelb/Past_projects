The dev, train and test file are directly fetched from project requirement.
The .idea file is generated by the Python Pycharm IDE automatically.

ProcessDevV1 File (Used to deal with developing data):
The BinTermStatistics program is used to substract combination of binary terms mentioned in the research report. For those binary terms extracted, each of whose weight is also calcluated using the accumulator model derieved from TF-IDF model as mentioned in the research paper. 
The DevFileStat program is used to process each sentences and categories them based on the actual label by each sentence. 
The DevSentenceStat program is used to calculate the weights for each binary tokens taken out and store those information in sorted order in files.
The DevEvaluateModel is used to evaluate the accuracy / recall / specificity of given "threashold" (higher than this value predicted as "Y" while lower predicted as "N".

ProcessTrain (Used to deal with training data):
For BinTermStatistics program, TrainFileStat and TrainSentenceStat, the effects are similar to ones developed in ProcessDevV1 file.
The TrainEvaluateModel trains the model and given out three models based on the needs of ensuring accuracy, recall and both correspondingly.

EvaluateTrain: Majorly used to evaluate the training model using dev.txt, the result will be compared to the one using unigram attributes from Weka.

Predict_Unknown: Predicts the text.txt data given labels unknown. This file shows the final out put of this research. The possible attributes discovered are stored in YesBinTokenFreqs.txt file, while three models used to predict are applied in PredictTxt.py file. Output "Predict on test twits threshold 6144.56840278.txt" provides a result aiming at ensuring a high recall of test.txt,output "Predict on test twits threshold 12845.8445626.txt" aims at giving a result which balance the accuracy and recall of prediction, while file "Predict on test twits threshold 18875.3904762.txt" tries to give a model which is more accurate. 

For the whole research, the new attributes discovered which might have correlation to ADR is stored in YesBinTokenFreqs.txt.



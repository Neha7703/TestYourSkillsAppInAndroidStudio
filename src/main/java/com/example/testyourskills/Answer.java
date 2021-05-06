package com.example.testyourskills;

public class Answer {

    private int optionA,optionB,optionC,optionD,questionID,answerID;

    public Answer(int questionid,int optiona,int optionb,int optionc,int optiond,int answerid)
    {
        questionID=questionid;
        optionA=optiona;
        optionB=optionb;
        optionC=optionc;
        optionD=optiond;
        answerID=answerid;
    }


    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionID() {
        return questionID;
    }

    public int getAnswerID() {
        return answerID;
    }
}
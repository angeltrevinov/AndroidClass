package com.example.androidquiz;


// Question class, holds the information for each question
// =========================================================
public class Question {
    public String strQuestion;
    public Boolean bAnswer;
    // -----------------------------------------------------
    public Question(
            // constructor
            String strQuestion,
            boolean bAnswer
    ) {
        this.strQuestion = strQuestion;
        this.bAnswer = bAnswer;
    }
}

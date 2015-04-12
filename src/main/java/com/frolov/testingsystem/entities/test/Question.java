package com.frolov.testingsystem.entities.test;

import java.util.List;

public class Question {

    public Test test;
    public String content;
    public List<Answer> answerList;
    public Answer trueAnswer;
    public List<Answer> trueAnswerList;
    public boolean isDeleted;

}
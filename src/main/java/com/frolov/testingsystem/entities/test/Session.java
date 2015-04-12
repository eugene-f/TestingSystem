package com.frolov.testingsystem.entities.test;

import java.util.List;
import java.util.Map;

public class Session {

    public Test test;
    public List<Question> openQuestionList;
    public List<Question> closeQuestionList;
    public Map<Question, Answer> closeQuestionMap;
    public int currentTime;

}
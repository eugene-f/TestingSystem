package com.frolov.testingsystem.entities.test;

import com.frolov.testingsystem.entities.Discipline;
import com.frolov.testingsystem.entities.user.Tutor;

import java.util.List;

public class Test {

    public Tutor author;
    public Discipline discipline;
    public List<Question> questionList;
    public List<Result> resultList;
    public int time;
    public boolean isActive;
    public boolean isDeleted;

}
package com.frolov.testingsystem.entities.user;

import com.frolov.testingsystem.entities.test.Result;
import com.frolov.testingsystem.entities.test.Session;
import com.frolov.testingsystem.entities.test.Test;

import java.util.List;

public class Student extends BaseUser {

    public List<Test> completedTestList;
    public List<Result> resultList;
    public List<Test> toPassTestList;
    public Test currentTest;
    public Session currentSession;

}
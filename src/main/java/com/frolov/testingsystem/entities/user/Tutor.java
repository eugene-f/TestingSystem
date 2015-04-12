package com.frolov.testingsystem.entities.user;

import com.frolov.testingsystem.entities.test.Result;
import com.frolov.testingsystem.entities.test.Test;

import java.util.List;

public class Tutor extends BaseUser {

    public List<Test> testList;
    public List<Result> testResultList;

}
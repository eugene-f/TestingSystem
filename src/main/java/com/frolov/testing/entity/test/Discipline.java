package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class Discipline extends BaseEntity {

    private String name;
    private List<Test> tests = new ArrayList<>();

    public Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

}

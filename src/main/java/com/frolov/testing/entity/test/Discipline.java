package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Контейнер для классификации тестов по определенным темат
 * Содержит список тестов данной категории
 */
public class Discipline extends BaseEntity {

    private String name;
    private List<Test> tests = new ArrayList<>();

    public Discipline(Long id, String name) {
        super(id);
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

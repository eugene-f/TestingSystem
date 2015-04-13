package com.frolov.testing.entity;

import com.frolov.testing.entity.test.Test;

import java.util.List;
import java.util.UUID;

public class Discipline {

    private int id;
    private UUID uuid;
    private String name;
    private List<Test> tests;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
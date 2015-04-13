package com.frolov.testing.entity.user;

import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;

import java.util.List;

public class Tutor extends BaseUser {

    private List<Test> tests;
    private List<Session> completedSessions;

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    public List<Session> getCompletedSessions() {
        return completedSessions;
    }

    public void setCompletedSessions(List<Session> completedSessions) {
        this.completedSessions = completedSessions;
    }

}
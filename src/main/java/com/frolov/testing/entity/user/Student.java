package com.frolov.testing.entity.user;

import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;

import java.util.List;

public class Student extends BaseUser {

    private List<Session> completedSessions;
    private Session currentSession;
    private List<Test> toPassTests;

    public List<Session> getCompletedSessions() {
        return completedSessions;
    }

    public void setCompletedSessions(List<Session> completedSessions) {
        this.completedSessions = completedSessions;
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public List<Test> getToPassTests() {
        return toPassTests;
    }

    public void setToPassTests(List<Test> toPassTests) {
        this.toPassTests = toPassTests;
    }

}
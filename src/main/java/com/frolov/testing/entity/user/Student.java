package com.frolov.testing.entity.user;

import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;

import java.util.List;
import java.util.UUID;

public class Student extends BaseUser {

    private List<Session> completedSessions;
    private Session currentSession;
    private List<Test> toPassTests;

    @Override
    public UUID getUuid() {
        return super.getUuid();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public boolean isDeleted() {
        return super.isDeleted();
    }

    @Override
    public void setDeleted(boolean deleted) {
        super.setDeleted(deleted);
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public String getPasswordHash() {
        return super.getPasswordHash();
    }

    @Override
    public void setPasswordHash(String passwordHash) {
        super.setPasswordHash(passwordHash);
    }

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

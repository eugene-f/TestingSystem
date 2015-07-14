package com.frolov.testing.entity.user;

import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.structure.Department;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends BaseUser {

    private static final UserType TYPE = UserType.Tutor;
    private final Department department;
    private List<Test> createdTests = new ArrayList<>();
    private List<Session> completedSessions = new ArrayList<>();

    public Tutor(String email, Department department) {
        super(TYPE, email);
        this.department = department;
    }

    public Tutor(String email, String passwordHash, Department department) {
        super(TYPE, email, passwordHash);
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public List<Test> getCreatedTests() {
        return createdTests;
    }

    public void setCreatedTests(List<Test> createdTests) {
        this.createdTests = createdTests;
    }

    public List<Session> getCompletedSessions() {
        return completedSessions;
    }

    public void setCompletedSessions(List<Session> completedSessions) {
        this.completedSessions = completedSessions;
    }
}

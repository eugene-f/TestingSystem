package com.frolov.testing.entity.user;

import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.structure.Department;

import java.util.List;

/**
 * Создает тесты
 * Просмативает результаты прохождения созданных тестов
 * Назначать группам или отдельным студентам тесты для прохождения
 */
public class Tutor extends BaseUser {

    private final Department department;
    private List<Test> createdTests;
    private List<Session> completedSessions;

    public Tutor(Long id, String firstName, String lastName, String email, String passwordHash, Department department) {
        super(id, firstName, lastName, email, passwordHash);
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

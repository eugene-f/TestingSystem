package com.frolov.testing.entity.user;

import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.structure.Department;

import java.util.ArrayList;
import java.util.List;

/**
 * Создает тесты
 * Просмативает результаты прохождения созданных тестов
 * Назначать группам или отдельным студентам тесты для прохождения
 */
public class Tutor extends BaseUser {

    private static final Type type = Type.Tutor;
    private final Department department;
    private List<Test> createdTests = new ArrayList<>();
    private List<Session> completedSessions = new ArrayList<>();

    public Tutor(Long id, String email, Department department) {
        super(id, email);
        this.department = department;
    }

    public Tutor(Long id, String email, String passwordHash, Department department) {
        super(id, email, passwordHash);
        this.department = department;
    }

    public Tutor(Long id, String email, String firstName, String lastName, String passwordHash, Department department) {
        super(id, email, firstName, lastName, passwordHash);
        this.department = department;
    }

    public static Type getType() {
        return type;
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

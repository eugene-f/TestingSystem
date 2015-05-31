package com.frolov.testing.entity.user;

import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.structure.Group;

import java.util.List;

/**
 * Принадлежит определенной группе
 * Может проходить тесты
 * Может просматривать результаты прохождения тестов
 * Может добавлять тесты в список для прохождения
 */
public class Student extends BaseUser {

    private final Group group;
    private List<Session> sessions;
    private List<Test> toPassTests;

    public Student(Long id, String firstName, String lastName, String email, String passwordHash, Group group) {
        super(id, firstName, lastName, email, passwordHash);
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public List<Test> getToPassTests() {
        return toPassTests;
    }

    public void setToPassTests(List<Test> toPassTests) {
        this.toPassTests = toPassTests;
    }

}

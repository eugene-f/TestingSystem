package com.frolov.testing.entity.user;

import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.structure.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Принадлежит определенной группе
 * Может проходить тесты
 * Может просматривать результаты прохождения тестов
 * Может добавлять тесты в список для прохождения
 */
public class Student extends BaseUser {

    private static final UserType TYPE_STUDENT = UserType.Student;
    private final Group group;
    private List<Session> sessions = new ArrayList<>();
    private List<Test> toPassTests = new ArrayList<>();

    public Student(String email, Group group) {
        super(TYPE_STUDENT, email);
        this.group = group;
    }

    public Student(String email, String passwordHash, Group group) {
        super(TYPE_STUDENT, email, passwordHash);
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

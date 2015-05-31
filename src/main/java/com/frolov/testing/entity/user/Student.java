package com.frolov.testing.entity.user;

import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.structure.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Принадлежит определенной группе
 * Может проходить тесты
 * Может просматривать результаты прохождения тестов
 * Может добавлять тесты в список для прохождения
 */
public class Student extends BaseUser {

    private static final Type type = Type.Student;
    private final Group group;
    private List<Session> sessions = new ArrayList<>();
    private List<Test> toPassTests = new ArrayList<>();

    public Student(Long id, String email, Group group) {
        super(id, email);
        this.group = group;
    }

    public Student(Long id, String email, String passwordHash, Group group) {
        super(id, email, passwordHash);
        this.group = group;
    }

    public Student(Long id, String email, String firstName, String lastName, String passwordHash, Group group) {
        super(id, email, firstName, lastName, passwordHash);
        this.group = group;
    }

    public static Type getType() {
        return type;
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

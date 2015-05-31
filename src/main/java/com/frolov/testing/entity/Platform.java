package com.frolov.testing.entity;

import com.frolov.testing.entity.test.Discipline;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.structure.Group;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import org.h2.engine.User;

import java.util.List;

/**
 * Эмуляция действующей платвормы и базы данных
 */
public class Platform {

    private List<User> users;
    private List<Tutor> tutors;
    private List<Group> groups;
    private List<Student> students;
    private List<Discipline> disciplines;
    private List<Test> tests;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(List<Tutor> tutors) {
        this.tutors = tutors;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }
}

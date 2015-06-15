package com.frolov.testing.entity;

import com.frolov.testing.entity.test.Answer;
import com.frolov.testing.entity.test.Configuration;
import com.frolov.testing.entity.test.Discipline;
import com.frolov.testing.entity.test.Question;
import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.Admin;
import com.frolov.testing.entity.structure.Department;
import com.frolov.testing.entity.structure.Faculty;
import com.frolov.testing.entity.structure.Group;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import org.h2.engine.User;

import java.util.List;

/**
 * Эмуляция базы данных
 */
public class Platform {

    // todo: delete

    private List<User> users;
    private List<Admin> admins;
    private List<Faculty> faculties;
    private List<Department> departments;
    private List<Tutor> tutors;
    private List<Group> groups;
    private List<Student> students;
    private List<Discipline> disciplines;
    private List<Test> tests;
    private List<Question> questions;
    private List<Answer> answers;
    private List<Configuration> configurations;
    private List<Session> sessions;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Configuration> getConfigurations() {
        return configurations;
    }

    public void setConfigurations(List<Configuration> configurations) {
        this.configurations = configurations;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

}

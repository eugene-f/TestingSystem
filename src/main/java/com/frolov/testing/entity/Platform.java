package com.frolov.testing.entity;

import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;

import java.util.List;

public class Platform {

    private List<Tutor> tutors;
    private List<Student> students;
    private List<Discipline> disciplines;
    private List<Test> tests;

    public List<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(List<Tutor> tutors) {
        this.tutors = tutors;
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
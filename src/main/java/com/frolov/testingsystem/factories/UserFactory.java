package com.frolov.testingsystem.factories;

import com.frolov.testingsystem.Utils;
import com.frolov.testingsystem.entities.user.Student;
import com.frolov.testingsystem.entities.user.Tutor;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFactory {

    public static Tutor createTutor() {
        Tutor tutor = new Tutor();

        tutor.id = Math.abs(Utils.RANDOM.nextInt());
        tutor.uuid = UUID.randomUUID();
        tutor.firstName = Lorem.getFirstName();
        tutor.lastName = Lorem.getLastName();
        tutor.email = tutor.firstName + "_" + tutor.lastName + "@gmail.com";
        tutor.passwordHash = Lorem.getZipCode();

        tutor.testList = new ArrayList<>();
        tutor.testResultList = new ArrayList<>();

        return tutor;
    }

    public static List<Tutor> createTutorList(int count) {
        List<Tutor> tutorList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tutorList.add(createTutor());
        }

        return tutorList;
    }

    public static Student createStudent() {
        Student student = new Student();

        student.id = Math.abs(Utils.RANDOM.nextInt());
        student.uuid = UUID.randomUUID();
        student.firstName = Lorem.getFirstName();
        student.lastName = Lorem.getLastName();
        student.email = student.firstName + "_" + student.lastName + "@gmail.com";
        student.passwordHash = Lorem.getZipCode();

        student.completedTestList = new ArrayList<>();
        student.resultList = new ArrayList<>();
        student.toPassTestList = new ArrayList<>();
        student.currentTest = null;
        student.currentSession = null;

        return student;
    }

    public static List<Student> createStudentList(int count) {
        List<Student> studentList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            studentList.add(createStudent());
        }

        return studentList;
    }

}
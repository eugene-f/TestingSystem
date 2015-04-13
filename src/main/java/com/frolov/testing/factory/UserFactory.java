package com.frolov.testing.factory;

import com.frolov.testing.Util;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserFactory {

    public static Tutor createTutor() {
        Tutor tutor = new Tutor();

        tutor.setId(Math.abs(Util.RANDOM.nextInt()));
        tutor.setUuid(UUID.randomUUID());
        tutor.setFirstName(Lorem.getFirstName());
        tutor.setLastName(Lorem.getLastName());
        tutor.setEmail(tutor.getFirstName() + "_" + tutor.getLastName() + "@gmail.com");
        tutor.setPasswordHash(Lorem.getZipCode());

        tutor.setTests(new ArrayList<>());
        tutor.setCompletedSessions(new ArrayList<>());

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

        student.setId(Math.abs(Util.RANDOM.nextInt()));
        student.setUuid(UUID.randomUUID());
        student.setFirstName(Lorem.getFirstName());
        student.setLastName(Lorem.getLastName());
        student.setEmail(student.getFirstName() + "_" + student.getLastName() + "@gmail.com");
        student.setPasswordHash(Lorem.getZipCode());

        student.setCompletedSessions(new ArrayList<>());
        student.setToPassTests(new ArrayList<>());
        student.setCurrentSession(null);

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
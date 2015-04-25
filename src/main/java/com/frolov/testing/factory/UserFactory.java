package com.frolov.testing.factory;

import com.frolov.testing.Util;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public static BaseUser initUser(BaseUser user) {

        user.setId(Math.abs(Util.RANDOM.nextLong()));
        user.setFirstName(Lorem.getFirstName());
        user.setLastName(Lorem.getLastName());
        user.setEmail(user.getFirstName() + "_" + user.getLastName() + "@gmail.com");
        user.setPasswordHash(Lorem.getZipCode());

        return user;
    }

    public static Tutor createTutor() {
        Tutor tutor = new Tutor();

        initUser(tutor);

        tutor.setCreatedTests(TestFactory.createTestList(1));
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

        initUser(student);

        student.setCompletedSessions(new ArrayList<>());
        student.setToPassTests(TestFactory.createTestList(1));
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

package com.frolov.testing.factory;

import com.frolov.testing.entity.structure.Department;
import com.frolov.testing.entity.structure.Faculty;
import com.frolov.testing.entity.structure.Group;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public static Tutor createTutor() {
        Tutor tutor = new Tutor(
                Lorem.getFirstName() + "_" + Lorem.getLastName() + "@gmail.com",
                new Department(
                        new Faculty(Lorem.getWords(3, 5)),
                        Lorem.getWords(3, 5)
                )
        );

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
        Student student = new Student(
                Lorem.getFirstName() + "_" + Lorem.getLastName() + "@gmail.com",
                new Group(
                        new Faculty(Lorem.getWords(3, 5)),
                        Lorem.getWords(3, 5)
                )
        );
        student.setToPassTests(TestFactory.createTestList(1));

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

package com.frolov.testing.factory;

import com.frolov.testing.ConstantContainer;
import com.frolov.testing.entity.user.structure.Department;
import com.frolov.testing.entity.user.structure.Faculty;
import com.frolov.testing.entity.user.structure.Group;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public static Tutor createTutor() {
        Tutor tutor = new Tutor(
                Math.abs(ConstantContainer.RANDOM.nextLong()),
                Lorem.getFirstName(),
                Lorem.getLastName(),
                Lorem.getFirstName() + "_" + Lorem.getLastName() + "@gmail.com",
                Lorem.getZipCode(),
                new Department(
                        null,
                        new Faculty(
                                null,
                                Lorem.getWords(3, 5)
                        ),
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
                Math.abs(ConstantContainer.RANDOM.nextLong()),
                Lorem.getFirstName(),
                Lorem.getLastName(),
                Lorem.getFirstName() + "_" + Lorem.getLastName() + "@gmail.com",
                Lorem.getZipCode(),
                new Group(
                        null,
                        new Faculty(
                                null,
                                Lorem.getWords(3, 5)
                        ),
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

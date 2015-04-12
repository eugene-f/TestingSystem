package com.frolov.testingsystem.factories;

import com.frolov.testingsystem.entities.Discipline;
import com.frolov.testingsystem.entities.Platform;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;

public class PlatformFactory {

    public static int tutorsCount = 3;
    public static int studentsCount = 5;
    public static int testsCount = 7;
    public static int disciplineCount = 3;

    public static Platform createPlatform() {
        Platform platform = new Platform();

        platform.tutorList = new ArrayList<>();
        platform.studentList = new ArrayList<>();
        platform.disciplineList = new ArrayList<>();
        platform.testList = new ArrayList<>();

        platform.tutorList.addAll(UserFactory.createTutorList(tutorsCount));
        platform.studentList.addAll(UserFactory.createStudentList(studentsCount));
        platform.disciplineList.addAll(PlatformFactory.createDisciplineList(disciplineCount));
        platform.testList.addAll(TestFactory.createTestList(testsCount));

        return platform;
    }

    public static Discipline createDiscipline() {
        Discipline discipline = new Discipline();

        discipline.name = Lorem.getWords(1, 3);
        discipline.testList = new ArrayList<>();

        return discipline;
    }

    public static List<Discipline> createDisciplineList (int count) {
        List<Discipline> disciplineList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            disciplineList.add(createDiscipline());
        }

        return disciplineList;
    }
}
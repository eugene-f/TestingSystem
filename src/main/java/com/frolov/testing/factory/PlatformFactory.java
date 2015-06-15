package com.frolov.testing.factory;

import com.frolov.testing.entity.test.Discipline;
import com.frolov.testing.entity.Platform;
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

        platform.setTutors(new ArrayList<>());
        platform.setStudents(new ArrayList<>());
        platform.setDisciplines(new ArrayList<>());
        platform.setTests(new ArrayList<>());

        platform.getTutors().addAll(UserFactory.createTutorList(tutorsCount));
        platform.getStudents().addAll(UserFactory.createStudentList(studentsCount));
        platform.getDisciplines().addAll(PlatformFactory.createDisciplineList(disciplineCount));
        platform.getTests().addAll(TestFactory.createTestList(testsCount));

        return platform;
    }

    public static Discipline createDiscipline() {
        Discipline discipline = new Discipline(Lorem.getWords(1, 3));

        discipline.setTests(new ArrayList<>());

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

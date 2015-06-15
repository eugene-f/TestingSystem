package com.frolov.testing.entity.structure;

import com.frolov.testing.entity.BaseEntity;
import com.frolov.testing.entity.user.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Содержит студентов
 * Для группы тьютором может назначаться тесты для прохождения
 */
public class Group extends BaseEntity {

    private final Faculty faculty;
    private String name;
    private List<Student> students = new ArrayList<>();

    public Group(Faculty faculty, String name) {
        this.faculty = faculty;
        this.name = name;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

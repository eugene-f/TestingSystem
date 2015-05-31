package com.frolov.testing.entity.user.structure;

import com.frolov.testing.entity.BaseEntity;
import com.frolov.testing.entity.user.Tutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Содержит тьюторов
 */
public class Department extends BaseEntity {

    private final Faculty faculty;
    private String name;
    private List<Tutor> tutors = new ArrayList<>();

    public Department(Long id, Faculty faculty, String name) {
        super(id);
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

    public List<Tutor> getTutors() {
        return tutors;
    }

    public void setTutors(List<Tutor> tutors) {
        this.tutors = tutors;
    }

}

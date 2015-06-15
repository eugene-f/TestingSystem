package com.frolov.testing.entity.structure;

import com.frolov.testing.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends BaseEntity {

    private String name;
    private List<Department> departments = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}

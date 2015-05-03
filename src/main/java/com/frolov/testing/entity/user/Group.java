package com.frolov.testing.entity.user;

import com.frolov.testing.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class Group extends BaseEntity {

    private String name;
    private List<Student> students = new ArrayList<>();

}

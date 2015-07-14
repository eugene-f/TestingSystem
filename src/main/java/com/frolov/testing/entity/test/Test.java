package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;
import com.frolov.testing.entity.user.Tutor;

import java.util.ArrayList;
import java.util.List;

public class Test extends BaseEntity {

    private final Tutor author;
    private String name;
    private Discipline discipline;
    private List<Question> questions = new ArrayList<>();
    private Configuration configuration;
    private boolean publicated = false;

    public Test(Tutor author) {
        this.author = author;
    }

    public Tutor getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public boolean isPublicated() {
        return publicated;
    }

    public void setPublicated(boolean publicated) {
        this.publicated = publicated;
    }

}

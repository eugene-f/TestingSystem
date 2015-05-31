package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;
import com.frolov.testing.entity.user.Tutor;

import java.util.ArrayList;
import java.util.List;

/**
 * Создается тьютором, который является его автором
 * Содержит список вопросов
 * Принадлежить определенной категории
 */
public class Test extends BaseEntity {

    private final Tutor author;
    private String name;
    private Discipline discipline;
    private List<Question> questions = new ArrayList<>();
    private Config config;
    private boolean publicated = false;

    public Test(Long id, Tutor author, String name, Discipline discipline) {
        super(id);
        this.author = author;
        this.name = name;
        this.discipline = discipline;
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

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public boolean isPublicated() {
        return publicated;
    }

    public void setPublicated(boolean publicated) {
        this.publicated = publicated;
    }

}

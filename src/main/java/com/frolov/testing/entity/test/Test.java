package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;
import com.frolov.testing.entity.Discipline;
import com.frolov.testing.entity.user.Tutor;

import java.util.List;
import java.util.UUID;

public class Test extends BaseEntity {

    private Tutor author; // todo: make final
    private String name;
    private Discipline discipline;
    private List<Question> questions;
    private byte minutesToPass;
    private boolean publicated = false;
    private List<Session> completedSessions; // todo: delete

    @Override
    public UUID getUuid() {
        return super.getUuid();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public boolean isDeleted() {
        return super.isDeleted();
    }

    @Override
    public void setDeleted(boolean deleted) {
        super.setDeleted(deleted);
    }

    public Tutor getAuthor() {
        return author;
    }

    public void setAuthor(Tutor author) {
        this.author = author;
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

    public byte getMinutesToPass() {
        return minutesToPass;
    }

    public void setMinutesToPass(byte minutesToPass) {
        this.minutesToPass = minutesToPass;
    }

    public boolean isPublicated() {
        return publicated;
    }

    public void setPublicated(boolean publicated) {
        this.publicated = publicated;
    }

    public List<Session> getCompletedSessions() {
        return completedSessions;
    }

    public void setCompletedSessions(List<Session> completedSessions) {
        this.completedSessions = completedSessions;
    }

}

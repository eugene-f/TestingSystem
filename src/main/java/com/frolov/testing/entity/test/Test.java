package com.frolov.testing.entity.test;

import com.frolov.testing.entity.Discipline;
import com.frolov.testing.entity.user.Tutor;

import java.util.List;

public class Test {

    private Tutor author;
    private Discipline discipline;
    private List<Question> questions;
    private List<Session> completedSessions; // todo: delete
    private byte minutesToPass;
    private boolean active;
    private boolean deleted;

    public Tutor getAuthor() {
        return author;
    }

    public void setAuthor(Tutor author) {
        this.author = author;
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

    public List<Session> getCompletedSessions() {
        return completedSessions;
    }

    public void setCompletedSessions(List<Session> completedSessions) {
        this.completedSessions = completedSessions;
    }

    public byte getMinutesToPass() {
        return minutesToPass;
    }

    public void setMinutesToPass(byte minutesToPass) {
        this.minutesToPass = minutesToPass;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
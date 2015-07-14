package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;

public class Answer extends BaseEntity {

    private final Question question;
    private String content;
    private boolean correct; // todo: select solution

    public Answer(Question question) {
        this.question = question;
    }

    public Question getQuestion() {
        return question;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}

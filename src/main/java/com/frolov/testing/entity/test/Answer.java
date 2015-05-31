package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;

import java.util.UUID;

/**
 * Ответ на вопрос
 * Может быть верным или нет
 */
public class Answer extends BaseEntity {

    private final Question question;
    private String content;
    private boolean correct; // todo: select solution

    public Answer(Long id, Question question, String content) {
        super(id);
        this.question = question;
        this.content = content;
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

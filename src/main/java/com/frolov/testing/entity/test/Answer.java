package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;

import java.util.UUID;

public class Answer extends BaseEntity {

    private String content;
    private boolean correct; // todo: delete

    @Override
    public UUID getUuid() {
        return super.getUuid();
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public void setId(Integer id) {
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

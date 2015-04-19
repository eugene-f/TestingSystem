package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;

import java.util.List;
import java.util.UUID;

public class Question extends BaseEntity {

    private String content;
    private List<Answer> answers;
    private Answer trueAnswer; // todo: delete

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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answer getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(Answer trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

}

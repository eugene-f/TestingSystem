package com.frolov.testing.entity.test;

import java.util.List;

public class Question {

    private String content;
    private List<Answer> answers;
    private Answer trueAnswer; // todo: delete
    private boolean deleted;

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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
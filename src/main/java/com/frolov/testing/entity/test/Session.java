package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;
import com.frolov.testing.entity.user.Student;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Session extends BaseEntity {

    private Test test;  // todo: make final
    private Student student;  // todo: make final
    private Date startDate;  // todo: make final
    private Map<Question, Answer> completedQuestionAnswerMap;
    private byte result;

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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Map<Question, Answer> getCompletedQuestionAnswerMap() {
        return completedQuestionAnswerMap;
    }

    public void setCompletedQuestionAnswerMap(Map<Question, Answer> completedQuestionAnswerMap) {
        this.completedQuestionAnswerMap = completedQuestionAnswerMap;
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

}

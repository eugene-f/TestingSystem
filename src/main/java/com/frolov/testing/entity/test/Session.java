package com.frolov.testing.entity.test;

import com.frolov.testing.entity.user.Student;

import java.util.Date;
import java.util.Map;

public class Session {

    private Test test;
    private Student student;
    private Map<Question, Answer> completedQuestionAnswerMap;
    private Date startDate;
    private byte result;
    private boolean deleted;

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

    public Map<Question, Answer> getCompletedQuestionAnswerMap() {
        return completedQuestionAnswerMap;
    }

    public void setCompletedQuestionAnswerMap(Map<Question, Answer> completedQuestionAnswerMap) {
        this.completedQuestionAnswerMap = completedQuestionAnswerMap;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
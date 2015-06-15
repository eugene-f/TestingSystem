package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;
import com.frolov.testing.entity.user.Student;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Содержит информацию о текущем тестировании и его результатах
 */
public class Session extends BaseEntity {

    private final Test test;
    private final Student student;
    private final Date startDate = new Date(); // todo: add finished time
    private Map<Question, Answer> studentAnswers = new HashMap<>(); // todo: select solution
    private Byte percentResult;
    private boolean finished;

    public Session(Test test, Student student) {
        this.test = test;
        this.student = student;
    }

    public Test getTest() {
        return test;
    }

    public Student getStudent() {
        return student;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Map<Question, Answer> getStudentAnswers() {
        return studentAnswers;
    }

    public void setStudentAnswers(Map<Question, Answer> studentAnswers) {
        this.studentAnswers = studentAnswers;
    }

    public Byte getPercentResult() {
        return percentResult;
    }

    public void setPercentResult(Byte percentResult) {
        this.percentResult = percentResult;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}

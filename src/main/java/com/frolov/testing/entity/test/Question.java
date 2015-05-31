package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Вопрос для теста
 * Содержит списов вариантов ответа
 * Содержит верный ответ
 */
public class Question extends BaseEntity {

    private final Test test;
    private String content;
    private Map<Answer, Boolean> answersMap; // todo: select solution
    private List<Answer> answers; // todo: select solution
    private Answer correctAnswer; // todo: select solution

    public Question(Long id, Test test, String content) {
        super(id);
        this.test = test;
        this.content = content;
    }

    public Test getTest() {
        return test;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<Answer, Boolean> getAnswersMap() {
        return answersMap;
    }

    public void setAnswersMap(Map<Answer, Boolean> answersMap) {
        this.answersMap = answersMap;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

}

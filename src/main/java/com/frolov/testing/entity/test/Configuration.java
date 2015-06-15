package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;

/**
 * Содержит параметры прохождения тестирования
 * Которые задаются тьютором перед публикацией теста
 */
public class Configuration extends BaseEntity {

    private final Test test;
    private byte minutesToPass;
    private byte questionCountToView; // Количество вопросов из теста
    private boolean shuffleQuestion; // Перемешивание вопросов
    private boolean shuffleAnswer; // Перемешивание вариантов ответов
    private boolean showCorrect; // Показ правильных ответов
    private boolean takeAgain; // Возможность пересдачи

    public Configuration(Test test) {
        this.test = test;
    }

    public Test getTest() {
        return test;
    }

    public byte getMinutesToPass() {
        return minutesToPass;
    }

    public void setMinutesToPass(byte minutesToPass) {
        this.minutesToPass = minutesToPass;
    }

    public byte getQuestionCountToView() {
        return questionCountToView;
    }

    public void setQuestionCountToView(byte questionCountToView) {
        this.questionCountToView = questionCountToView;
    }

    public boolean isShuffleQuestion() {
        return shuffleQuestion;
    }

    public void setShuffleQuestion(boolean shuffleQuestion) {
        this.shuffleQuestion = shuffleQuestion;
    }

    public boolean isShuffleAnswer() {
        return shuffleAnswer;
    }

    public void setShuffleAnswer(boolean shuffleAnswer) {
        this.shuffleAnswer = shuffleAnswer;
    }

    public boolean isShowCorrect() {
        return showCorrect;
    }

    public void setShowCorrect(boolean showCorrect) {
        this.showCorrect = showCorrect;
    }

    public boolean isTakeAgain() {
        return takeAgain;
    }

    public void setTakeAgain(boolean takeAgain) {
        this.takeAgain = takeAgain;
    }
}

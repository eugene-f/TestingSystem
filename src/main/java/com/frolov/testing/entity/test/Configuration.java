package com.frolov.testing.entity.test;

import com.frolov.testing.entity.BaseEntity;

/**
 * Содержит параметры прохождения тестирования
 * Которые задаются тьютором перед публикацией теста
 */
public class Configuration extends BaseEntity {

    private byte minutesToPass;
    private int questionCountToView; //Количество вопросов из теста
    private boolean shuffleQuestion; //Перемешивание вопросов
    private boolean shuffleAnswer; //Перемешивание вариантов ответов
    private boolean showCorrect; //Показ правильных ответов
    private boolean takeAgain; //Возможность пересдачи

    public Configuration(Long id) {
        super(id);
    }

    public Configuration(Long id, byte minutesToPass, int questionCountToView, boolean shuffleQuestion, boolean shuffleAnswer, boolean showCorrect, boolean takeAgain) {
        super(id);
        this.minutesToPass = minutesToPass;
        this.questionCountToView = questionCountToView;
        this.shuffleQuestion = shuffleQuestion;
        this.shuffleAnswer = shuffleAnswer;
        this.showCorrect = showCorrect;
        this.takeAgain = takeAgain;
    }

    public byte getMinutesToPass() {
        return minutesToPass;
    }

    public void setMinutesToPass(byte minutesToPass) {
        this.minutesToPass = minutesToPass;
    }

    public int getQuestionCountToView() {
        return questionCountToView;
    }

    public void setQuestionCountToView(int questionCountToView) {
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

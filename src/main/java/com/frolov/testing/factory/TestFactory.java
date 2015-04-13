package com.frolov.testing.factory;

import com.frolov.testing.Util;
import com.frolov.testing.entity.test.Answer;
import com.frolov.testing.entity.test.Question;
import com.frolov.testing.entity.test.Test;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;

public class TestFactory {

    public static Test createTest() {
        Test test = new Test();

        test.setAuthor(null);
        test.setDiscipline(null);
        test.setQuestions(new ArrayList<>());
        test.setCompletedSessions(new ArrayList<>());
        test.setMinutesToPass((byte) ((Util.RANDOM.nextInt(7) + 3) * 10));
        test.setActive(false);
        test.setDeleted(false);

        return test;
    }

    public static List<Test> createTestList (int count) {
        List<Test> testList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            testList.add(createTest());
        }

        return testList;
    }

    public static Question createQuestion() {
        Question question = new Question();

        question.setContent(Lorem.getWords(3, 7));
        question.setAnswers(new ArrayList<>());
        question.setDeleted(false);

        return question;
    }

    public static List<Question> createQuestionList(int count) {
        List<Question> questionList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            questionList.add(createQuestion());
        }

        return questionList;
    }

    public static Answer createAnswer() {
        Answer answer = new Answer();

        answer.setContent(Lorem.getWords(3, 5));
        answer.setCorrect(false);
        answer.setDeleted(false);

        return answer;
    }

    public static List<Answer> createAnswerList (int count) {
        List<Answer> answerList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            answerList.add(createAnswer());
        }

        return answerList;
    }

}
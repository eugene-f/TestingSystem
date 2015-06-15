package com.frolov.testing.factory;

import com.frolov.testing.entity.test.Answer;
import com.frolov.testing.entity.test.Question;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.Tutor;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;

public class TestFactory {

    public static Test createTest() {
        Tutor tutor = new Tutor("123@123.123", null);
        tutor.setId((long) 123);
        Test test = new Test(tutor);
        test.setId(null);
        test.setName(Lorem.getWords(3, 5));
        test.setDiscipline(null);
        test.setQuestions(null);
        test.setConfiguration(null);
        test.setPublicated(false);
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
        Question question = new Question(null);

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
        Answer answer = new Answer(null);

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
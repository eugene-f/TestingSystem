package com.frolov.testingsystem.factories;

import com.frolov.testingsystem.Utils;
import com.frolov.testingsystem.entities.test.Answer;
import com.frolov.testingsystem.entities.test.Question;
import com.frolov.testingsystem.entities.test.Test;
import com.thedeanda.lorem.Lorem;

import java.util.ArrayList;
import java.util.List;

public class TestFactory {

    public static Test createTest() {
        Test test = new Test();

        test.author = null;
        test.discipline = null;
        test.questionList = new ArrayList<>();
        test.resultList = new ArrayList<>();
        test.time = (Utils.RANDOM.nextInt(7) + 3) * 10;
        test.isActive = false;
        test.isDeleted = false;

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

        question.test = null;
        question.content = Lorem.getWords(3, 7);
        question.answerList = new ArrayList<>();
        question.trueAnswer = null;
        question.trueAnswerList = new ArrayList<>();
        question.isDeleted = false;

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

        answer.question = null;
        answer.content = Lorem.getWords(3, 5);
        answer.isTrue = false;
        answer.isDeleted = false;

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
package com.frolov.testing.servlet;

import com.frolov.testing.Cookies;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.interfaces.DisciplineDao;
import com.frolov.testing.dao.jdbc.dao.JdbcDisciplineDao;
import com.frolov.testing.entity.test.Answer;
import com.frolov.testing.entity.test.Discipline;
import com.frolov.testing.entity.test.Question;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.Tutor;
import org.boon.Boon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TestCreator", urlPatterns = "/create-test")
public class TestCreator extends HttpServlet {

    private String title;
    private String disciplineName;
    private String questionCount;
    private String answerCount;
    private String publicated;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        initValues(request);
        Test test = createTestWithValues();

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/tutor/create_questions.jsp");
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/fill-test");
        request.setAttribute("test", test);
        request.setAttribute("question_count", questionCount);
        request.setAttribute("answer_count", answerCount);
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/tutor/create_test_form.jsp");
        requestDispatcher.forward(request, response);
    }

    private Test createTestWithValues() {
        Test test = new Test((Tutor) Cookies.getCurrentUser());
        test.setName(title);
        test.setQuestions(new ArrayList<>());
        test.setPublicated(false);

        final List<Question> questions = test.getQuestions();
        for (int i = 0; i < Integer.valueOf(questionCount); i++) {
            Question question = new Question(test);
            question.setContent("");
            question.setAnswers(new ArrayList<>());
            question.setCorrectAnswer(null);

            for (int j = 0; j < Integer.valueOf(answerCount); j++) {
                Answer answer = new Answer(question);
                answer.setContent("");
                answer.setCorrect(false);
            }

            questions.add(question);
        }

        return test;
    }

    private void initValues(HttpServletRequest request) {
        title = request.getParameter("title");
        disciplineName = request.getParameter("discipline");
//        questionCount = request.getParameter("questionCount");
//        answerCount = request.getParameter("answerCount");
        questionCount = request.getParameter("questionCountHidden");
        answerCount = request.getParameter("answerCountHidden");
        publicated = request.getParameter("publicated");
    }

}

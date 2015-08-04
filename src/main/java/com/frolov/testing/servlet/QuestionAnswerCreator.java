package com.frolov.testing.servlet;

import com.frolov.testing.Cookies;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.interfaces.DisciplineDao;
import com.frolov.testing.dao.jdbc.dao.JdbcDisciplineDao;
import com.frolov.testing.dao.jdbc.dao.JdbcTestDao;
import com.frolov.testing.entity.test.Answer;
import com.frolov.testing.entity.test.Discipline;
import com.frolov.testing.entity.test.Question;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.Tutor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "QuestionAnswerCreator", urlPatterns = "/fill-test")
public class QuestionAnswerCreator extends HttpServlet {

    String title;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        title = request.getParameter("title");

        final Test test = (Test) request.getAttribute("test");
        final String question_count = (String) request.getAttribute("question_count");
        final String answer_count = (String) request.getAttribute("answer_count");

        final List<Question> questions = test.getQuestions();
        for (Question question : questions) {
            final String questionContent = request.getParameter("question" + questions.indexOf(question));
            question.setContent(questionContent);

            final List<Answer> answers = question.getAnswers();
            for (Answer answer : answers) {
                final String answerContent = request.getParameter("answer" + answers.indexOf(answer));
                final String correct = request.getParameter("question" + questions.indexOf(question) + "AnswerCorrect");
                answer.setContent(answerContent);
                answer.setCorrect(Boolean.valueOf(correct));
            }

        }

//        final JdbcTestDao jdbcTestDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcTestDao.class);
//        jdbcTestDao.insert(test);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/tutor/create_question.jsp");
        requestDispatcher.forward(request, response);
    }

}

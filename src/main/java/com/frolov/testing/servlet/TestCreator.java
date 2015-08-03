package com.frolov.testing.servlet;

import com.frolov.testing.Cookies;
import com.frolov.testing.action.AccountActions;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.interfaces.DisciplineDao;
import com.frolov.testing.dao.jdbc.dao.JdbcDisciplineDao;
import com.frolov.testing.entity.test.Discipline;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.Tutor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestCreator", urlPatterns = "/create-test")
public class TestCreator extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String disciplineName = request.getParameter("discipline");
        String questionCount = request.getParameter("questionCount");
        String answerCount = request.getParameter("answerCount");
        String publicated = request.getParameter("publicated");

        DisciplineDao disciplineDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcDisciplineDao.class);
        Discipline discipline = disciplineDao.findByName(disciplineName);

        Test test = new Test((Tutor) Cookies.getCurrentUser());
        test.setName(title);
        test.setDiscipline(discipline);
        test.setPublicated(false);

//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create_questions.jsp");
        request.setAttribute("test", test);
        request.setAttribute("question_count", questionCount);
        request.setAttribute("answer_count", answerCount);
//        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/tutor/create_test_form.jsp");
        requestDispatcher.forward(request, response);
    }

}

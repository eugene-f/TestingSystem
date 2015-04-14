package com.frolov.testing.servlet;

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
        String discipline = request.getParameter("discipline");
        String minutesToPass = request.getParameter("minutesToPass");
        String questionCount = request.getParameter("questionCount");
        String answerCount = request.getParameter("answerCount");
        String active = request.getParameter("active");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create_questions.jsp");
        request.setAttribute("question_count", questionCount);
        request.setAttribute("answer_count", answerCount);
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/create_test.jsp");
        requestDispatcher.forward(request, response);
    }
}

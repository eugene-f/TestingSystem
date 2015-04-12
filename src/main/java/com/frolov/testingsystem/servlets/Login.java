package com.frolov.testingsystem.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login", urlPatterns = "/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (checkUser(email, password)) {
            response.sendRedirect("/main");
        } else {
            printWriter.println("Error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }

    public boolean checkUser(String email, String password) {
        if ("admin@test.com".equals(email)) {
            if ("admin".equals(password)) {
                return true;
            }
        }
        return false;
    }
}

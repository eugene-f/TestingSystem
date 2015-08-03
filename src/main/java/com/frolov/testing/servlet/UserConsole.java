package com.frolov.testing.servlet;

import com.frolov.testing.Cookies;
import com.frolov.testing.action.AccountActions;

import org.boon.Boon;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;

@WebServlet(name = "UserConsole", urlPatterns = "/console")
public class UserConsole extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/user/console.jsp");
        request.setAttribute("user", Cookies.getCurrentUser());
        requestDispatcher.forward(request, response);
    }

}

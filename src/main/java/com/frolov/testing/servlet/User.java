package com.frolov.testing.servlet;

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

@WebServlet(name = "User", urlPatterns = "/user")
public class User extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter printWriter = response.getWriter();
//        printWriter.println(Boon.toPrettyJson(AccountActions.getCurrentUser()));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/console/user.jsp");
        request.setAttribute("user", AccountActions.getCurrentUser());
        requestDispatcher.forward(request, response);
    }
}

package com.frolov.testing.servlet;

import com.frolov.testing.Cookies;
import com.frolov.testing.action.AccountActions;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.UserType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Registration", urlPatterns = "/registration")
public class Registration extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String fatherName = request.getParameter("fatherName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String userType = request.getParameter("userType");

        UserType type = null;
        switch (userType) {
            case "admin": type = UserType.Admin; break;
            case "tutor": type = UserType.Tutor; break;
            case "student": type = UserType.Student; break;
        }

        if (AccountActions.dbGetUserByEmail(email) == null) {
            if (password.equals(confirmPassword)) {
                BaseUser user = AccountActions.createUser(type, firstName, lastName, email, password);
                user.setFatherName(fatherName);
                Cookies.setCurrentUser(user);
                response.sendRedirect("/console");
            } else {
                printWriter.println("Пароли не совпадают");
            }
        } else {
            printWriter.println("Пользователь с таким email уже зарегестрирован");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registration.jsp");
        requestDispatcher.forward(request, response);
    }

}

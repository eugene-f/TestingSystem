package com.frolov.testing.servlet;

import com.frolov.testing.action.AccountActions;
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

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String userType = request.getParameter("userType");

        UserType type = null; // fixme
        switch (userType) {
            case "admin": type = UserType.Admin; break;
            case "tutor": type = UserType.Tutor; break;
            case "student": type = UserType.Student; break;
        }

        if (AccountActions.dbGetUserByEmail(email) == null) {
            if (password.equals(confirmPassword)) {
                AccountActions.createUser(type, firstName, lastName, email, password);
                response.sendRedirect("/account");
            } else {
                printWriter.println("Password does not match");
            }
        } else {
            printWriter.println("This email is already registered in the system\n");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registration.jsp");
        requestDispatcher.forward(request, response);
    }

}

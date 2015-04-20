package com.frolov.testing.servlet;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.jdbc.UserDao;

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
            response.sendRedirect("/account");
        } else {
            printWriter.println("You have entered incorrect email or password");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
        requestDispatcher.forward(request, response);
    }

    public static boolean checkUser(String email, String password) { // todo: make this method non-static
//        return checkUserInMemory(email, password);
        return checkUserInDatabase(email, password);
    }

    private static boolean checkUserInMemory(String email, String password) {
        for (BaseUser user : TestingSystem.USER_LIST) {
            if (user.getEmail().equals(email)) {
                if (user.getPasswordHash().equals(password)) {
                    TestingSystem.CURRENT_USER = user;
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkUserInDatabase(String email, String password) { // todo: make this method non-static
        BaseUser user = new UserDao().findByEmail(email);
        if (user.getPasswordHash().equals(password)) {
            TestingSystem.CURRENT_USER = user;
            return true;
        }
        return false;
    }

}

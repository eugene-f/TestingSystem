package com.frolov.testing.servlet;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.factory.UserFactory;
import com.frolov.testing.jdbc.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

        if (password.equals(confirmPassword)) {
            if (checkEmail(email)) { // todo: or (   getUserByEmail(email) == null   )
                createUser(firstName, lastName, email, password, userType);
                response.sendRedirect("/main");
            } else {
                printWriter.println("Error Email");
            }
        } else {
            printWriter.println("Error Password");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/registration.jsp");
        requestDispatcher.forward(request, response);
    }

    private void createUser(String firstName, String lastName, String email, String password, String userType) {
        BaseUser user = null;
        switch (userType) {
            case "tutor": user = UserFactory.createTutor(); break;
            case "student": user = UserFactory.createStudent(); break;
            default: return;
        }
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPasswordHash(password);
            switch (userType) {
                case "tutor": TestingSystem.PLATFORM.getTutors().add((Tutor) user); break;
                case "student": TestingSystem.PLATFORM.getStudents().add((Student) user); break;
                default: return;
            }
            TestingSystem.USER_LIST.add(user);
//            try {
//                new UserDao().insert(user);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }
    }

    private boolean checkEmail(String email) {
        for (BaseUser user : TestingSystem.USER_LIST) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

}

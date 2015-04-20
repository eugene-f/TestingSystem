package com.frolov.testing.servlet;

import com.frolov.testing.entity.Platform;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.factory.PlatformFactory;
import org.boon.Boon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TestingSystem", urlPatterns = "/ts")
public class TestingSystem extends HttpServlet {

    public static final Platform PLATFORM = PlatformFactory.createPlatform();
    public static final List<BaseUser> USER_LIST = new ArrayList<>();
    public static BaseUser CURRENT_USER;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        USER_LIST.addAll(PLATFORM.getTutors());
        USER_LIST.addAll(PLATFORM.getStudents());
        printWriter.println(Boon.toPrettyJson(PLATFORM));
    }
}

package com.frolov.testing.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        Connection connection = DriverManager.getConnection("jdbc:h2:database");
//        Connection connection = DriverManager.getConnection("jdbc:h2:file:D:/Work/Project/IdeaProjects/TestingSystem/database");
        Statement statement = connection.createStatement();
        boolean execute = statement.execute("CREATE TABLE TESTS (ID BIGINT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(127))");
        System.out.println("execute" + execute);
        statement.close();
        connection.close();
    }

}

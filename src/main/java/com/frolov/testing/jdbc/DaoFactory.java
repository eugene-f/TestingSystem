package com.frolov.testing.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DaoFactory<T extends BaseDao> {

    protected static final ResourceBundle database = ResourceBundle.getBundle("database");
    protected static final String DRIVER = database.getString("driver_class");
    protected static final String URL = database.getString("url");
    protected static final String USER = database.getString("username");
    protected static final String PASSWORD = database.getString("password");

    Connection connection;

    private DaoFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public T create(T t) {
        return t;
    }

}

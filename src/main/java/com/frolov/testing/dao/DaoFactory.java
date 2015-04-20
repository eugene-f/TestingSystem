package com.frolov.testing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

    private static final DaoFactory instance = new DaoFactory();
    private static final String URL = "jdbc:h2:database";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "sa";

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance;
    }

    public JdbcUserDao createJdbcUserDao() throws DaoException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new DaoException("Соединение не установлено", e);
        }
        return new JdbcUserDao(connection);
    }

}

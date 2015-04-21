package com.frolov.testing.dao;

import com.frolov.testing.jdbc.BaseDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcDaoFactory extends DaoFactory {

    private static final JdbcDaoFactory instance = new JdbcDaoFactory();
    private static final String URL = "jdbc:h2:database";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "sa";

    private JdbcDaoFactory() {
    }

    public static JdbcDaoFactory getInstance() {
        return instance;
    }

/*    public JdbcUserDao createJdbcUserDao() throws DaoException {
        Connection connection = null;
        connection = getConnection();
        return new JdbcUserDao(connection);
    }

    public JdbcTestDao createJdbcTestDao() throws DaoException {
        Connection connection = null;
        connection = getConnection();
        return new JdbcTestDao(connection);
    }*/

    private Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new DaoException("Соединение не установлено", e);
        }
        return connection;
    }

    public <T extends JdbcBaseDao> T create(Class<T> aClass) {
        T t;
        try {
            t = aClass.newInstance();
/*        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }*/
        } catch (Exception e) {
            throw new DaoException("Невозможно создать DAO для класса" + aClass, e);
        }
        t.setConnection(getConnection());
        return t;
    }

}

package com.frolov.testing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcDaoFactory extends DaoFactory {

//    Connection connection;

    private static final JdbcDaoFactory instance = new JdbcDaoFactory();
    private static final ResourceBundle database = ResourceBundle.getBundle("database");
    private static final String DRIVER = "org.h2.Driver"; // DRIVER = database.getString("driver_class");
    private static final String URL = database.getString("url");
    private static final String USERNAME = database.getString("username");
    private static final String PASSWORD = database.getString("password");

    private JdbcDaoFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static JdbcDaoFactory getInstance() {
        return instance;
    }

//    public JdbcUserDao createJdbcUserDao() throws DaoException { // fixme: old JdbcUserDao creator;
//        return new JdbcUserDao(getConnection());
//    }

//    public JdbcTestDao createJdbcTestDao() throws DaoException { // fixme: old JdbcTestDao creator;
//        return new JdbcTestDao(getConnection());
//    }

    private Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new DaoException("Соединение не установлено", e);
        }
        return connection;
    }

    @Override
    public <T extends /*JdbcBaseDao*/ Dao> T create(Class<T> daoClass) {
        T dao;
        try {
            dao = daoClass.newInstance();
//        } catch (InstantiationException e) { // fixme: exceptions
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        } catch (Exception e) {
            throw new DaoException("Невозможно создать DAO для класса " + daoClass, e);
        }
        ((JdbcBaseDao) dao).setConnection(getConnection());
        return dao;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().create(JdbcUserDao.class));
    }

}

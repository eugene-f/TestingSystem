package com.frolov.testing.dao;

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

//    public JdbcUserDao createJdbcUserDao() throws DaoException { // fixme: old JdbcUserDao creator;
//        Connection connection = null;
//        connection = getConnection();
//        return new JdbcUserDao(connection);
//    }
//
//    public JdbcTestDao createJdbcTestDao() throws DaoException { // fixme: old JdbcTestDao creator;
//        Connection connection = null;
//        connection = getConnection();
//        return new JdbcTestDao(connection);
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
    public <T extends JdbcBaseDao> T create(Class<T> daoClass) {
        T dao;
        try {
            dao = daoClass.newInstance();
//        } catch (InstantiationException e) { // fixme: unknown exceptions
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        } catch (Exception e) {
            throw new DaoException("Невозможно создать DAO для класса" + daoClass, e);
        }
        dao.setConnection(getConnection());
        return dao;
    }

}

package com.frolov.testing.dao.jdbc;

import com.frolov.testing.connection.ConnectionPool;
import com.frolov.testing.dao.Dao;
import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.DaoFactory;

import java.sql.Driver;
import java.sql.DriverManager;

public class JdbcDaoFactory extends DaoFactory {

//    Connection connection;

    private static final JdbcDaoFactory INSTANCE = new JdbcDaoFactory();

    private static final String DRIVER = "org.h2.Driver";
//    private static final ResourceBundle database = ResourceBundle.getBundle("database");
//    private static final String DRIVER = database.getString("driver_class");

    private static void loadDriverClass() {
        try {
            Class.forName(DRIVER);
            Driver driver = (Driver) Class.forName(DRIVER).newInstance();
            DriverManager.registerDriver(driver);
        } catch (Exception e) {
            throw new DaoException("Невозможно загрузить класс драйвера", e);
        }
    }

    private JdbcDaoFactory() {
        loadDriverClass();
    }

    public static JdbcDaoFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public <T extends Dao> T create(Class<T> daoClass) {
        T dao;
        try {
            dao = daoClass.newInstance();
        } catch (Exception e) {
            throw new DaoException("Невозможно создать DAO для класса " + daoClass, e);
        }
        ((JdbcBaseDao) dao).setConnection(ConnectionPool.getInstance().getConnection());
//        ((NewJdbcBaseDao) dao).setConnection(ConnectionPool.getInstance().getConnection());
        return dao;
    }

//    // old JdbcBaseDao creator;
//    public JdbcBaseDao createJdbcBaseDao() throws DaoException {
//        return new JdbcBaseDao(createConnection());
//    }

}

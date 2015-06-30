package com.frolov.testing.dao.jdbc;

import com.frolov.testing.connection.ConnectionPool;
import com.frolov.testing.dao.Dao;
import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.DaoFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Driver;
import java.sql.DriverManager;

public class JdbcDaoFactory extends DaoFactory {

    private static final Logger logger = LoggerFactory.getLogger(JdbcDaoFactory.class);

//    Connection connection;

    private static final JdbcDaoFactory INSTANCE = new JdbcDaoFactory();

    private static void loadDriverClass() {
        try {
            String driverName = JdbcProperties.getDRIVER();
            Class.forName(driverName);
            Driver driver = (Driver) Class.forName(driverName).newInstance();
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
//        ((JdbcBaseDao) dao).setConnection(ConnectionPool.getInstance().getConnection());
        ((JdbcAbstractBaseDao) dao).setConnection(ConnectionPool.getInstance().getConnection());
        return dao;
    }

//    // old JdbcBaseDao creator;
//    public JdbcBaseDao createJdbcBaseDao() throws DaoException {
//        return new JdbcBaseDao(createConnection());
//    }

}

package com.frolov.testing;

import com.frolov.testing.dao.DaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectionPool {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);

    private static final ConnectionPool instance = new ConnectionPool();

    private static final ResourceBundle database = ResourceBundle.getBundle("database");
    private static final String DRIVER = database.getString("driver_class");
    private static final String URL = database.getString("url");
    private static final String USERNAME = database.getString("username");
    private static final String PASSWORD = database.getString("password");

    private static final ArrayList<Connection> CONNECTIONS = new ArrayList<>();
    private static final int CONNECTION_COUNT = 5;

    static {
        try {
            Driver driver = (Driver) Class.forName(DRIVER).newInstance();
            DriverManager.registerDriver(driver);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        initConnections();
    }

    private static void initConnections() {
        for (int i = 0; i < CONNECTION_COUNT; i++) {
            CONNECTIONS.add(createConnection());
        }
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    private static Connection createConnection() {
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            logger.info("con create");
            return connection;
        } catch (SQLException e) {
            throw new ConnectionException("Не возможно создать соединение", e);
        }
    }

    private boolean checkConnection(Connection connection) {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    if (!connection.isReadOnly()) {
                        return true;
                    }
                }
            } catch (SQLException e) {
                throw new DaoException("Невозможно добавить соединение в пул", e);
            }
        }
        return false;
    }

    public void addConnection(Connection connection) {
        if (CONNECTIONS.size() <= CONNECTION_COUNT) {
            if (checkConnection(connection)) {
                logger.info("con add");
                CONNECTIONS.add(connection);
            }
        } else logger.info("con not add bec ful pol");
    }

    public Connection getConnection() {
        for (Connection connection : CONNECTIONS) {
            if (checkConnection(connection)) {
                logger.info("con get");
                CONNECTIONS.remove(connection);
                return connection;
            }
        }
        return createConnection();
    }

}

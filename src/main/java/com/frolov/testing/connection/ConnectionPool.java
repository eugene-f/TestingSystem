package com.frolov.testing.connection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConnectionPool {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);

    private static final ConnectionPool instance = new ConnectionPool();

    private static final ResourceBundle database = ResourceBundle.getBundle("database");
    private static final String URL = database.getString("url");
    private static final String USERNAME = database.getString("username");
    private static final String PASSWORD = database.getString("password");

    private static final ArrayList<Connection> CONNECTIONS = new ArrayList<>();
    private static final int CONNECTION_COUNT = 5;

    static {
//        JdbcDaoFactory.loadDriverClass();
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
//        Connection connection;
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            logger.info("con create");
            return connection; //
        } catch (SQLException e) {
            throw new ConnectionException("Не возможно создать соединение", e);
//            throw new DaoException("Соединение не установлено", e);
        }
//        return connection;
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
                logger.error("Невозможно добавить соединение в пул");
            }
        }
        return false;
    }

    public void addConnection(Connection connection) {
        if (CONNECTIONS.size() <= CONNECTION_COUNT) {
            if (checkConnection(connection)) {
                logger.info("Соединение добавлено");
                CONNECTIONS.add(connection);
            }
        } else {
            logger.info("Пулл соединений полон, соединение не добавлено");
        }
    }

    public Connection getConnection() {
        for (Connection connection : CONNECTIONS) {
            if (checkConnection(connection)) {
                logger.info("Соединение передано");
                CONNECTIONS.remove(connection);
                return connection;
            }
        }
        return createConnection();
    }

}

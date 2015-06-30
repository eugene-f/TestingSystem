package com.frolov.testing.connection;

import com.frolov.testing.dao.jdbc.JdbcProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public /*abstract*/ class ConnectionPool {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionPool.class);

    private static final ConnectionPool instance = new ConnectionPool();

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
            Connection connection = DriverManager.getConnection(
                    JdbcProperties.getURL(),
                    JdbcProperties.getUSERNAME(),
                    JdbcProperties.getPASSWORD()
            );
            logger.info("con create");
            return connection; //
        } catch (SQLException e) {
            throw new ConnectionException("Не возможно создать соединение", e);
//            throw new DaoException("Соединение не установлено", e);
        }
//        return connection;
    }

    private static boolean checkConnection(Connection connection) {
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

    public static void addConnection(Connection connection) {
        if (CONNECTIONS.size() <= CONNECTION_COUNT) {
            if (checkConnection(connection)) {
                logger.info("Соединение добавлено");
                CONNECTIONS.add(connection);
            }
        } else {
            logger.info("Пулл соединений полон, соединение не добавлено");
        }
    }

    public static Connection getConnection() {
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

package com.frolov.testing.dao.jdbc;

import com.frolov.testing.dao.Dao;
import com.frolov.testing.dao.DaoException;
import com.frolov.testing.entity.BaseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// todo: add mapping methods

public abstract class NewJdbcBaseDao<T extends BaseEntity> implements Dao<T>, JdbcMapper<T> {

    private final String TABLE_NAME;

    private final String GET_ALL;
    private final String INSERT;
    private final String FIND_BY_ID;
    private final String UPDATE;
    private final String DELETE_BY_ID;

    private /*final*/ Connection connection; // todo: make final

    public NewJdbcBaseDao(String tableName, String sqlInsert) {
        this.TABLE_NAME = tableName;
        this.GET_ALL = "SELECT * FROM " + TABLE_NAME;
        this.INSERT = sqlInsert;
//        this.INSERT = "INSERT INTO " + TABLE_NAME + " " + "(ID, NAME, DELETED)" + " " + "VALUES (NULL, ?, ?)";
        this.FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " " + "WHERE ID = ?";
        this.UPDATE = ""; // todo: write update script
        this.DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " " + "WHERE ID = ?";
    }

    public NewJdbcBaseDao(Connection connection, String tableName, String sqlInsert) {
        this.connection = connection;

        this.TABLE_NAME = tableName;
        this.GET_ALL = "SELECT * FROM " + TABLE_NAME;
        this.INSERT = sqlInsert;
//        this.INSERT = "INSERT INTO " + TABLE_NAME + " " + "(ID, NAME, DELETED)" + " " + "VALUES (NULL, ?, ?)";
        this.FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " " + "WHERE ID = ?";
        this.UPDATE = ""; // todo: write update script
        this.DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " " + "WHERE ID = ?";
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public List<T> mapToEntityList(ResultSet set) throws SQLException {
        List<T> list = new ArrayList<>();
        while (set.next()) { // fixme: double set iteration
//            set.previous();
            list.add(mapToEntity(set));
        }
        return list;
    }

    public Iterable<T> getAll() throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    public T insert(T entity) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(INSERT)) {
            mapToStatement(entity, statement);
            boolean execute = statement.execute();
            return entity; // fixme: set id to entity
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T findById(Long id) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public T update(T entity) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE)) {
            int i = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException();
        }
        return null;
    }

    public boolean deleteById(Long id) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(DELETE_BY_ID)) {
            statement.setLong(1, id);
            boolean execute = statement.execute();
            return execute;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public Connection beginTransaction() throws DaoException {
        try {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException("beginTransaction", e);
        }
        return connection;
    }
    public Connection commitTransaction() throws DaoException  {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new DaoException("commitTransaction", e);
        }
        return connection;
    }
    public Connection rollbackTransaction() throws DaoException  {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DaoException("rollbackTransaction", e);
        }
        return connection;
    }
    public Connection endTransaction() throws DaoException  {
        rollbackTransaction(); // move to try block
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DaoException("endTransaction", e);
        }
        return connection;
    }

}

package com.frolov.testing.dao.jdbc;

import com.frolov.testing.dao.Dao;
import com.frolov.testing.dao.DaoException;
import com.frolov.testing.entity.BaseEntity;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class JdbcBaseDao<T extends BaseEntity> implements Dao<T> {

    private /*final*/ Connection connection; // todo: make final

//    public JdbcBaseDao(Connection connection) {
//        this.connection = connection;
//    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public abstract String getTableName();

    public abstract Iterable<T> getAll() throws DaoException;

    public abstract T insert(T entity) throws DaoException;

    public abstract T findById(Long id) throws DaoException;

    public abstract T update(T entity) throws DaoException;

    public abstract boolean deleteById(Long id) throws DaoException;

//    public abstract void mapStatementToEntity(PreparedStatement preparedStatement, T entity) throws DaoException;

//    public abstract T mapEntityToStatement(T entity, PreparedStatement preparedStatement) throws DaoException;

//    public abstract T mapStatementToEntity(PreparedStatement preparedStatement) throws DaoException;

//    public abstract PreparedStatement mapEntityToStatement(T entity) throws DaoException;

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
        rollbackTransaction();
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            throw new DaoException("endTransaction", e);
        }
        return connection;
    }

}

package com.frolov.testing.dao;

import com.frolov.testing.entity.BaseEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class JdbcBaseDao<T extends BaseEntity> implements Dao<T> {

    private /*final*/ Connection connection;

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

}

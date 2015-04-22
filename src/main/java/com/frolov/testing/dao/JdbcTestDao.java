package com.frolov.testing.dao;

import com.frolov.testing.entity.test.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcTestDao extends JdbcBaseDao<Test> implements TestDao {

//    public JdbcTestDao(Connection connection) { // fixme: unknown constructor;
//        super(connection);
//    }

    @Override
    public Test insert(Test entity) throws DaoException {
        return null;
    }

    @Override
    public Test findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public Iterable<Test> getAll() throws DaoException {
        return null;
    }

    @Override
    public Test update(Test entity) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        return false;
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public Test mapStatementToEntity(PreparedStatement preparedStatement) throws DaoException {
        return null;
    }

    @Override
    public PreparedStatement mapEntityToStatement(Test entity) throws DaoException {
        return null;
    }
}

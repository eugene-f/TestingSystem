package com.frolov.testing.dao;

import com.frolov.testing.entity.test.Test;

import java.sql.Connection;

public class JdbcTestDao extends JdbcBaseDao<Test> implements TestDao {

    public JdbcTestDao(Connection connection) {
        super(connection);
    }

    @Override
    public Test insert(Test entity) throws DaoException {
        return null;
    }

    @Override
    public Test findById(Long id) throws DaoException {
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

}

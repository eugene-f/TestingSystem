package com.frolov.testing.dao;

import com.frolov.testing.entity.test.Test;

public class JdbcTestDao extends JdbcBaseDao<Test> implements TestDao {

    @Override
    public Test create(Test entity) throws DaoException {
        return null;
    }

    @Override
    public Test read(Long id) throws DaoException {
        return null;
    }

    @Override
    public Test update(Test entity) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }

}

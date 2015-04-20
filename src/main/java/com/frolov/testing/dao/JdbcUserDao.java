package com.frolov.testing.dao;

import com.frolov.testing.entity.user.BaseUser;

import java.sql.Connection;

public class JdbcUserDao extends JdbcBaseDao<BaseUser> implements UserDao {

    private Connection connection;

    public JdbcUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public BaseUser create(BaseUser entity) throws DaoException {
        return null;
    }

    @Override
    public BaseUser read(Long id) throws DaoException {
        return null;
    }

    @Override
    public BaseUser update(BaseUser entity) throws DaoException {
        return null;
    }

    @Override
    public boolean delete(Long id) throws DaoException {
        return false;
    }
}

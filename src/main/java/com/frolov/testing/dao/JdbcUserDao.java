package com.frolov.testing.dao;

import com.frolov.testing.entity.user.BaseUser;

import java.sql.Connection;

public class JdbcUserDao extends JdbcBaseDao<BaseUser> implements UserDao {

    private static final String TABLE_NAME = "USERS";
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORDHASH) VALUES (NULL, ?, ?, ?, ?)";

    public JdbcUserDao(Connection connection) {
        super(connection);
    }

    @Override
    public BaseUser insert(BaseUser entity) throws DaoException {
        return null;
    }

    @Override
    public BaseUser findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public BaseUser update(BaseUser entity) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        return false;
    }

    @Override
    public BaseUser findByEmail(String email) throws DaoException{
        return null;
    }
}

package com.frolov.testing.dao;

import com.frolov.testing.entity.user.BaseUser;

public interface UserDao extends Dao<BaseUser> {

    BaseUser findByEmail(String email) throws DaoException;

    @Override
    BaseUser insert(BaseUser entity) throws DaoException;

    @Override
    BaseUser findById(Long id) throws DaoException;

    @Override
    BaseUser update(BaseUser entity) throws DaoException;

    @Override
    boolean deleteById(Long id) throws DaoException;
}

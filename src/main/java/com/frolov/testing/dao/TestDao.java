package com.frolov.testing.dao;

import com.frolov.testing.entity.test.Test;

public interface TestDao extends Dao<Test> {

    @Override
    Test insert(Test entity) throws DaoException;

    @Override
    Test findById(Long id) throws DaoException;

    @Override
    Iterable<Test> getAll() throws DaoException;

    @Override
    Test update(Test entity) throws DaoException;

    @Override
    boolean deleteById(Long id) throws DaoException;

}

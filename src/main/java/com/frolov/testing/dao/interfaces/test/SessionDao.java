package com.frolov.testing.dao.interfaces.test;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.interfaces.Dao;
import com.frolov.testing.entity.test.Session;

public interface SessionDao extends Dao<Session> {

    @Override
    Iterable<Session> getAll() throws DaoException;

    @Override
    Session insert(Session entity) throws DaoException;

    @Override
    Session findById(Long id) throws DaoException;

    @Override
    Session update(Session entity) throws DaoException;

    @Override
    boolean deleteById(Long id) throws DaoException;

    Iterable<Session> findByTestId(Long id) throws DaoException;

    Iterable<Session> findByStudentId(Long id) throws DaoException;

}

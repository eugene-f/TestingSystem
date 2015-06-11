package com.frolov.testing.dao.interfaces.test;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.interfaces.Dao;
import com.frolov.testing.entity.test.Discipline;

public interface DisciplineDao extends Dao<Discipline> {

    @Override
    Iterable<Discipline> getAll() throws DaoException;

    @Override
    Discipline insert(Discipline entity) throws DaoException;

    @Override
    Discipline findById(Long id) throws DaoException;

    @Override
    Discipline update(Discipline entity) throws DaoException;

    @Override
    boolean deleteById(Long id) throws DaoException;

    Discipline findByName(String name) throws DaoException;

}

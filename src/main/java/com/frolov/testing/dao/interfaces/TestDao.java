package com.frolov.testing.dao.interfaces;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.Dao;
import com.frolov.testing.entity.test.Discipline;
import com.frolov.testing.entity.test.Test;

public interface TestDao extends Dao<Test> {

    @Override
    Iterable<Test> getAll() throws DaoException;

    @Override
    Test insert(Test entity) throws DaoException;

    @Override
    Test findById(Long id) throws DaoException;

    @Override
    Test update(Test entity) throws DaoException;

    @Override
    boolean deleteById(Long id) throws DaoException;

    Iterable<Test> findByDiscipline(Discipline discipline) throws DaoException;

    Iterable<Test> findByName(String name) throws DaoException;

    Iterable<Test> findByAuthorId(Long id) throws DaoException;

}

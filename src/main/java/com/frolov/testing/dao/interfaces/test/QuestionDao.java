package com.frolov.testing.dao.interfaces.test;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.interfaces.Dao;
import com.frolov.testing.entity.test.Question;

public interface QuestionDao extends Dao<Question> {

    @Override
    Iterable<Question> getAll() throws DaoException;

    @Override
    Question insert(Question entity) throws DaoException;

    @Override
    Question findById(Long id) throws DaoException;

    @Override
    Question update(Question entity) throws DaoException;

    @Override
    boolean deleteById(Long id) throws DaoException;

    Iterable<Question> findByTestId(Long id) throws DaoException;

}

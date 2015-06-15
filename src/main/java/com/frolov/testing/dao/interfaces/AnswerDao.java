package com.frolov.testing.dao.interfaces;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.Dao;
import com.frolov.testing.entity.test.Answer;

public interface AnswerDao extends Dao<Answer> {

    @Override
    Iterable<Answer> getAll() throws DaoException;

    @Override
    Answer insert(Answer entity) throws DaoException;

    @Override
    Answer findById(Long id) throws DaoException;

    @Override
    Answer update(Answer entity) throws DaoException;

    @Override
    boolean deleteById(Long id) throws DaoException;

    Iterable<Answer> findByQuestionId(Long id) throws DaoException;

    Answer findCorrectByQuestionId(Long id) throws DaoException;

}

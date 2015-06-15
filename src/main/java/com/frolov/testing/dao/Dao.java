package com.frolov.testing.dao;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.entity.BaseEntity;

public interface Dao<T extends BaseEntity> {

    Iterable<T> getAll() throws DaoException;

    T insert(T entity) throws DaoException;

    T findById(Long id) throws DaoException;

    T update(T entity) throws DaoException;

    boolean deleteById(Long id) throws DaoException;

}

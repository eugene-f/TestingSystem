package com.frolov.testing.dao.xml;

import com.frolov.testing.dao.interfaces.Dao;
import com.frolov.testing.dao.DaoException;
import com.frolov.testing.entity.BaseEntity;

public abstract class XmlBaseDao<T extends BaseEntity> implements Dao<T> {

    public abstract T insert(T entity) throws DaoException;

    public abstract T findById(Long id) throws DaoException;

    public abstract Iterable<T> getAll() throws DaoException;

    public abstract T update(T entity) throws DaoException;

    public abstract boolean deleteById(Long id) throws DaoException;

}

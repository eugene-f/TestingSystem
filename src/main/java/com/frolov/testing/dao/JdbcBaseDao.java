package com.frolov.testing.dao;

import com.frolov.testing.entity.BaseEntity;

public abstract class JdbcBaseDao<T extends BaseEntity> implements Dao {

    public abstract T create(T entity) throws DaoException;
    public abstract T read(Long id) throws DaoException;
    public abstract T update(T entity) throws DaoException;
    public abstract boolean delete(Long id) throws DaoException;

}

package com.frolov.testing.jdbc;

import com.frolov.testing.entity.BaseEntity;

public abstract class BaseDao<T extends BaseEntity> {

//    public abstract List<T> getAll();
    public abstract Integer insert(T entity);
    public abstract T findById(Integer id);
//    public abstract T update(T entity);
//    public abstract boolean markAsDeleted(Integer id);
//    public abstract boolean markAsDeleted(T entity);
    public abstract boolean delete(Integer id);
//    public abstract boolean delete(T entity);

}

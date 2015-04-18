package com.frolov.testing.jdbc;

import com.frolov.testing.entity.BaseEntity;

import java.util.ResourceBundle;

public abstract class BaseDao<T extends BaseEntity> {

    protected static final ResourceBundle database = ResourceBundle.getBundle("database");
    protected static final String DRIVER = database.getString("driver_class");
    protected static final String URL = database.getString("url");
    protected static final String USER = database.getString("username");
    protected static final String PASSWORD = database.getString("password");

    public abstract void create(T entity);

    public abstract void read(T entity);

    public abstract void update(T entity);

    public abstract void delete(T entity);

    public abstract void findById(T entity);

}

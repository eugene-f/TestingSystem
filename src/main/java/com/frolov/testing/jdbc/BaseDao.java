package com.frolov.testing.jdbc;

import com.frolov.testing.entity.BaseEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public abstract class BaseDao<T extends BaseEntity> {

    protected static final ResourceBundle database = ResourceBundle.getBundle("database");
    protected static final String DRIVER = database.getString("driver_class");
    protected static final String URL = database.getString("url");
    protected static final String USER = database.getString("username");
    protected static final String PASSWORD = database.getString("password");

    Connection connection;

    public BaseDao() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        connection.close();
    }

//    public abstract List<T> getAll();
    public abstract int insert(T entity);
    public abstract T findById(int id);
//    public abstract T update(T entity);
//    public abstract boolean markAsDeleted(int id);
//    public abstract boolean markAsDeleted(T entity);
    public abstract boolean delete(int id);
//    public abstract boolean delete(T entity);

}

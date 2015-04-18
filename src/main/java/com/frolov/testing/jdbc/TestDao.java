package com.frolov.testing.jdbc;

import com.frolov.testing.entity.test.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDao extends BaseDao<Test> {

    private static final String TABLE_NAME = "TESTS";

    Connection connection;

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORDHASH) VALUES (NULL, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE ID = ?";

    public TestDao() {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection1 = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        connection.close();

    }

    public void insert(Test test) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        preparedStatement.setString(1, test.getName());
        preparedStatement.execute();
    }

    @Override
    public void create(Test entity) {

    }

    @Override
    public void read(Test entity) {

    }

    @Override
    public void update(Test entity) {

    }

    @Override
    public void delete(Test entity) {

    }

    @Override
    public void findById(Test entity) {

    }
}

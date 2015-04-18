package com.frolov.testing.jdbc;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.factory.UserFactory;
import com.frolov.testing.servlet.TestingSystem;

import java.sql.*;

public class UserDao extends BaseDao<BaseUser> {

    private static final String TABLE_NAME = "USERS";

    Connection connection;

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORDHASH) VALUES (NULL, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE ID = ?";
    private static final String FIND_BY_EMAIL = "SELECT * FROM " + TABLE_NAME + " WHERE EMAIL = ?";

    public UserDao() {

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

    public void insert(BaseUser user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPasswordHash());
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        if (user.getId() == 0) {
            user.setId(resultSet.getInt(1));
        }

        preparedStatement.close();
    }

    public BaseUser findById(int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        Student student = UserFactory.createStudent();
        student.setId(resultSet.getInt(1));
        student.setFirstName(resultSet.getString(2));
        student.setLastName(resultSet.getString(3));
        student.setEmail(resultSet.getString(4));
        student.setPasswordHash(resultSet.getString(5));
        TestingSystem.USER_LIST.add(student);

        preparedStatement.close();
        return student;
    }

    public BaseUser findByEmail(String email) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EMAIL);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();
        Student student = UserFactory.createStudent();
        student.setId(resultSet.getInt(1));
        student.setFirstName(resultSet.getString(2));
        student.setLastName(resultSet.getString(3));
        student.setEmail(resultSet.getString(4));
        student.setPasswordHash(resultSet.getString(5));
        TestingSystem.USER_LIST.add(student);
        TestingSystem.USER = student;

        preparedStatement.close();
        return student;
    }

    @Override
    public void create(BaseUser entity) {

    }

    @Override
    public void read(BaseUser entity) {

    }

    @Override
    public void update(BaseUser entity) {

    }

    @Override
    public void delete(BaseUser entity) {

    }

    @Override
    public void findById(BaseUser entity) {

    }
}

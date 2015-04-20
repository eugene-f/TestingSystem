package com.frolov.testing.jdbc;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.factory.UserFactory;

import java.sql.*;

public class UserDao extends BaseDao<BaseUser> {

    public Connection connection;

    private static final String TABLE_NAME = "USERS";

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORDHASH) VALUES (NULL, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE ID = ?";
    private static final String FIND_BY_EMAIL = "SELECT * FROM " + TABLE_NAME + " WHERE EMAIL = ?";
    private static final String DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " WHERE ID = ?";

//    public UserDao(Connection connection) {
//        this.connection = connection;
//    }

    @Override
    public Integer insert(BaseUser entity) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);

            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getPasswordHash());

            ResultSet resultSet = preparedStatement.executeQuery();
            int id = resultSet.getInt("id");

            preparedStatement.close();
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser findById(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Student student = createStudent(resultSet);

            preparedStatement.close();
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public BaseUser findByEmail(String email) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_EMAIL);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            Student student = createStudent(resultSet);

            preparedStatement.close();
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Student createStudent(ResultSet resultSet) throws SQLException {
        resultSet.next();
        Student student = UserFactory.createStudent();
        student.setId(resultSet.getInt("ID"));
        student.setFirstName(resultSet.getString("FIRSTNAME"));
        student.setLastName(resultSet.getString("LASTNAME"));
        student.setEmail(resultSet.getString("EMAIL"));
        student.setPasswordHash(resultSet.getString("PASSWORDHASH"));
        return student;
    }

    @Override
    public boolean delete(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);

            preparedStatement.setInt(1, id);

            boolean execute = preparedStatement.execute();

            preparedStatement.close();
            return execute;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

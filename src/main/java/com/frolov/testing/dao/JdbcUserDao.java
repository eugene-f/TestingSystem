package com.frolov.testing.dao;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDao extends JdbcBaseDao<BaseUser> implements UserDao {

    private static final String TABLE_NAME = "USERS";
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORDHASH) VALUES (NULL, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE ID = ?";
    private static final String FIND_BY_EMAIL = "SELECT * FROM " + TABLE_NAME + " WHERE EMAIL = ?";
    private static final String DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " WHERE ID = ?";

    @Override
    public Connection getConnection() {
        return super.getConnection();
    }

    @Override
    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public BaseUser insert(BaseUser entity) throws DaoException {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT);
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getPasswordHash());
            ResultSet resultSet = preparedStatement.executeQuery();
            int id = resultSet.getInt("id");
            preparedStatement.close();
//            return id; // fixme: make User return
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser findById(Long id) throws DaoException {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = JdbcMapper.getStudentByResultSet(resultSet);
            preparedStatement.close();
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<BaseUser> getAll() throws DaoException {
        return null;
    }

    @Override
    public BaseUser update(BaseUser entity) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            boolean execute = preparedStatement.execute();
            preparedStatement.close();
            return execute;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public BaseUser findByEmail(String email) throws DaoException {
        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            Student student = JdbcMapper.getStudentByResultSet(resultSet);
            preparedStatement.close();
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser findByFirstName(String firstName) throws DaoException {
        return null;
    }

    @Override
    public BaseUser findByLastName(String lastName) throws DaoException {
        return null;
    }

    @Override
    public BaseUser findByFullName(String fullName) throws DaoException {
        return null;
    }

}

package com.frolov.testing.dao.jdbc;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.UserDao;
import com.frolov.testing.dao.mapper.JdbcMapper;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDao extends JdbcBaseDao<BaseUser> implements UserDao {

    private static final String TABLE_NAME = "USERS";
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (ID, ROLE, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD_HASH, DELETED) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE ID = ?";
    private static final String GET_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String UPDATE = ""; // todo: write update script
    private static final String DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " WHERE ID = ?";
    private static final String FIND_BY_EMAIL = "SELECT * FROM " + TABLE_NAME + " WHERE EMAIL = ?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM " + TABLE_NAME + " WHERE FIRST_NAME = ?";
    private static final String FIND_BY_LAST_NAME = "SELECT * FROM " + TABLE_NAME + " WHERE LAST_NAME = ?";
    private static final String FIND_BY_FULL_NAME = "SELECT * FROM " + TABLE_NAME + " WHERE EMAIL = ?"; // todo: write find script
    private static final String GET_TUTORS = "SELECT * FROM " + TABLE_NAME + " WHERE ROLE = com.frolov.testing.entity.user.Tutor";
    private static final String GET_STUDENTS = "SELECT * FROM " + TABLE_NAME + " WHERE ROLE = com.frolov.testing.entity.user.Student";

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
    public Iterable<BaseUser> getAll() throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return JdbcMapper.map(resultSet);
        } catch (SQLException e) {
            throw new DaoException();
        }
//        return null;
    }

    @Override
    public BaseUser insert(BaseUser entity) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT)) {
            JdbcMapper.mapUserToStatment(entity, preparedStatement);
            preparedStatement.execute();
//            return entity; // fixme: make User return
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser findById(Long id) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return JdbcMapper.mapResultToUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser update(BaseUser entity) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE)) {
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new DaoException();
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(DELETE_BY_ID)) {
            preparedStatement.setLong(1, id);
            return preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public BaseUser findByEmail(String email) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            return JdbcMapper.mapResultToUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser findByFirstName(String firstName) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_FIRST_NAME)) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser findByLastName(String lastName) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_LAST_NAME)) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser findByFullName(String fullName) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_FULL_NAME)) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Tutor> getTutors() throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(GET_TUTORS)) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Student> getStudents() throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(GET_STUDENTS)) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

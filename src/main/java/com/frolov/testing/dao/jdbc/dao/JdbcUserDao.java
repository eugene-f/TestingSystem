package com.frolov.testing.dao.jdbc.dao;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.interfaces.UserDao;
import com.frolov.testing.dao.jdbc.JdbcAbstractBaseDao;
import com.frolov.testing.dao.jdbc.JdbcBaseDao;
import com.frolov.testing.dao.jdbc.JdbcMapper;
import com.frolov.testing.entity.user.Admin;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.entity.user.UserType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserDao extends JdbcAbstractBaseDao<BaseUser> implements UserDao {

    private static final String TABLE_NAME = "USERS";

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
            "(ID, TYPE_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD_HASH, DELETED) " +
            "VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_EMAIL = "SELECT * FROM " + TABLE_NAME + " " +
            " WHERE EMAIL = ?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM " + TABLE_NAME + " " +
            " WHERE FIRST_NAME = ?";
    private static final String FIND_BY_LAST_NAME = "SELECT * FROM " + TABLE_NAME + " " +
            " WHERE LAST_NAME = ?";
    private static final String FIND_BY_FULL_NAME = "SELECT * FROM " + TABLE_NAME + " " +
            " WHERE FULL_NAME = ?"; // todo: write find script
    private static final String GET_TUTORS = "SELECT * FROM " + TABLE_NAME + " " +
            " WHERE TYPE_ID = ?";
    private static final String GET_STUDENTS = "SELECT * FROM " + TABLE_NAME + " " +
            " WHERE TYPE_ID = ?";

    public JdbcUserDao() {
        super(TABLE_NAME, INSERT);
    }

    @Override
    public BaseUser findByEmail(String email) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_EMAIL)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser findByFirstName(String firstName) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_EMAIL)) {
            preparedStatement.setString(1, firstName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser findByLastName(String lastName) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_EMAIL)) {
            preparedStatement.setString(1, lastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseUser findByFullName(String fullName) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_EMAIL)) {
            preparedStatement.setString(1, fullName);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Deprecated
    public Iterable<Tutor> getTutors() throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(GET_TUTORS)) {
            preparedStatement.setLong(1, UserType.Tutor.ordinal());
            ResultSet resultSet = preparedStatement.executeQuery();
//            return mapToEntityList(resultSet); // fixme: cast types
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Deprecated
    public Iterable<Student> getStudents() throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(GET_STUDENTS)) {
            preparedStatement.setLong(1, UserType.Student.ordinal());
            ResultSet resultSet = preparedStatement.executeQuery();
//            return mapToEntityList(resultSet); // fixme: cast types
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PreparedStatement mapToStatement(BaseUser entity, PreparedStatement statement) {
        try {
            statement.setLong(1, entity.getType().ordinal());
            statement.setString(2, entity.getFirstName());
            statement.setString(3, entity.getLastName());
            statement.setString(4, entity.getEmail());
            statement.setString(5, entity.getPasswordHash());
            statement.setBoolean(6, entity.isDeleted());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    @Override
    public BaseUser mapToEntity(ResultSet set) {
        BaseUser baseUser = null;
        try {
//            set.next();
            long id = set.getLong("ID");
            long typeId = set.getLong("TYPE_ID");
            String firstName = set.getString("FIRST_NAME");
            String lastName = set.getString("LAST_NAME");
            String email = set.getString("EMAIL");
            String passwordHash = set.getString("PASSWORD_HASH");
            boolean deleted = set.getBoolean("DELETED");

//            set.next(); // fixme: double set iteration
            switch (UserType.values()[(int) typeId]) {
                case Admin:
                    baseUser = new Admin(email);
                    break;
                case Tutor:
                    baseUser = new Tutor(email, null);
                    break;
                case Student:
                    baseUser = new Student(email, null);
                    break;
            }
//            if (baseUser != null) { // todo: delete if check because all type values be cased
                baseUser.setId(id);
                baseUser.setFirstName(firstName);
                baseUser.setLastName(lastName);
                baseUser.setPasswordHash(passwordHash);
                baseUser.setDeleted(deleted);
//            }
        } catch (SQLException e) {
            logger.info("Ошибка при маппинге");
            e.printStackTrace();
        }
        return baseUser;
    }

}

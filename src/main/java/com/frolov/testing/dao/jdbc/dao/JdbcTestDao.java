package com.frolov.testing.dao.jdbc.dao;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.interfaces.TestDao;
import com.frolov.testing.dao.jdbc.JdbcBaseDao;
import com.frolov.testing.dao.jdbc.JdbcMapper;
import com.frolov.testing.entity.test.Configuration;
import com.frolov.testing.entity.test.Discipline;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTestDao extends JdbcBaseDao<Test> implements TestDao, JdbcMapper<Test> {

    private static final String TABLE_NAME = "TESTS";

    private static final String GET_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
            "(ID, AUTHOR_ID, NAME, DISCIPLINE_ID, CONFIGURATION_ID, PUBLICATED, DELETED)" + " " +
            "VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE ID = ?";
    private static final String UPDATE = ""; // todo: write update script
    private static final String DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " " +
            "WHERE ID = ?";
    private static final String FIND_BY_DISCIPLINE = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE DISCIPLINE_ID = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE NAME = ?";
    private static final String FIND_BY_AUTHOR_ID = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE AUTHOR_ID = ?";

    public JdbcTestDao() {
    }

    public JdbcTestDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Iterable<Test> getAll() throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public Test insert(Test entity) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(INSERT)) {
            mapToStatement(entity, statement);
            boolean execute = statement.execute();
            return entity; // fixme: set id to entity
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Test findById(Long id) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Test update(Test entity) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE)) {
            int i = statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException();
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(DELETE_BY_ID)) {
            statement.setLong(1, id);
            boolean execute = statement.execute();
            return execute;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Iterable<Test> findByDiscipline(Discipline discipline) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_DISCIPLINE)) {
            statement.setLong(1, discipline.getId());
            ResultSet resultSet = statement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Test> findByName(String name) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Iterable<Test> findByAuthorId(Long id) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_AUTHOR_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PreparedStatement mapToStatement(Test entity, PreparedStatement statement) {
        try {
            statement.setLong(1, entity.getAuthor().getId());
            statement.setString(2, entity.getName());
            statement.setLong(3, entity.getDiscipline().getId());
            statement.setLong(4, entity.getConfiguration().getId());
            statement.setBoolean(5, entity.isPublicated());
            statement.setBoolean(6, entity.isDeleted());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    @Override
    public Test mapToEntity(ResultSet set) {
        Test test = null;
        try {
            long id = set.getLong("ID");
            long author_id = set.getLong("AUTHOR_ID");
            String name = set.getString("NAME");
            long discipline_id = set.getLong("DISCIPLINE_ID");
            long configuration_id = set.getLong("CONFIGURATION_ID");
            boolean publicated = set.getBoolean("PUBLICATED");
            boolean deleted = set.getBoolean("DELETED");

            JdbcUserDao userDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcUserDao.class);
            BaseUser user = userDao.findById(author_id);
            Tutor tutor = (Tutor) user;

            JdbcDisciplineDao disciplineDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcDisciplineDao.class);
            Discipline discipline = disciplineDao.findById(discipline_id);

            JdbcConfigurationDao configurationDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcConfigurationDao.class);
            Configuration configuration = configurationDao.findById(configuration_id);

            test = new Test(tutor);
            test.setId(id);
            test.setName(name);
            test.setDiscipline(discipline);
            test.setConfiguration(configuration);
            test.setPublicated(publicated);
            test.setDeleted(deleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return test;
    }

}
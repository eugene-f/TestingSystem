package com.frolov.testing.dao.jdbc.dao;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.interfaces.TestDao;
import com.frolov.testing.dao.jdbc.JdbcAbstractBaseDao;
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

public class JdbcTestDao extends JdbcAbstractBaseDao<Test> implements TestDao {

    private static final String TABLE_NAME = "TESTS";

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
            "(ID, AUTHOR_ID, NAME, DISCIPLINE_ID, CONFIGURATION_ID, PUBLICATED, DELETED)" + " " +
            "VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_DISCIPLINE = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE DISCIPLINE_ID = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE NAME = ?";
    private static final String FIND_BY_AUTHOR_ID = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE AUTHOR_ID = ?";

    public JdbcTestDao() {
        super(TABLE_NAME, INSERT);
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

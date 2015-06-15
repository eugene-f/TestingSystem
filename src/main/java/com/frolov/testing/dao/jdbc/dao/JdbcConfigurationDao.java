package com.frolov.testing.dao.jdbc.dao;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.interfaces.ConfigurationDao;
import com.frolov.testing.dao.jdbc.JdbcBaseDao;
import com.frolov.testing.dao.jdbc.JdbcMapper;
import com.frolov.testing.entity.test.Configuration;
import com.frolov.testing.entity.test.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConfigurationDao extends JdbcBaseDao<Configuration> implements ConfigurationDao, JdbcMapper<Configuration> {

    private static final String TABLE_NAME = "CONFIGURATIONS";

    private static final String GET_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
            "(ID, TEST_ID, MINUTES_TO_PASS, QUESTION_COUNT_TO_VIEW, SHUFFLE_QUESTION, SHUFFLE_ANSWER, SHOW_CORRECT, TAKE_AGAIN, DELETED)" + " " +
            "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE ID = ?";
    private static final String UPDATE = ""; // todo: write update script
    private static final String DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " " +
            "WHERE ID = ?";
    private static final String FIND_BY_TEST_ID = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE TEST_ID = ?";

    public JdbcConfigurationDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Iterable<Configuration> getAll() throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public Configuration insert(Configuration entity) throws DaoException {
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
    public Configuration findById(Long id) throws DaoException {
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
    public Configuration update(Configuration entity) throws DaoException {
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
    public Configuration findByTestId(Long id) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_TEST_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PreparedStatement mapToStatement(Configuration entity, PreparedStatement statement) {
        try {
            statement.setLong(1, entity.getTest().getId());
            statement.setByte(2, entity.getMinutesToPass());
            statement.setByte(3, entity.getQuestionCountToView());
            statement.setBoolean(4, entity.isShuffleQuestion());
            statement.setBoolean(5, entity.isShuffleAnswer());
            statement.setBoolean(6, entity.isShowCorrect());
            statement.setBoolean(7, entity.isTakeAgain());
            statement.setBoolean(8, entity.isDeleted());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    @Override
    public Configuration mapToEntity(ResultSet set) {
        Configuration configuration = null;
        try {
            long id = set.getLong("ID");
            long test_id = set.getLong("TEST_ID");
            byte minutes_to_pass = set.getByte("MINUTES_TO_PASS");
            byte question_count_to_view = set.getByte("QUESTION_COUNT_TO_VIEW");
            boolean shuffle_question = set.getBoolean("SHUFFLE_QUESTION");
            boolean shuffle_answer = set.getBoolean("SHUFFLE_ANSWER");
            boolean show_correct = set.getBoolean("SHOW_CORRECT");
            boolean take_again = set.getBoolean("TAKE_AGAIN");
            boolean deleted = set.getBoolean("DELETED");

            JdbcTestDao testDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcTestDao.class);
            Test test = testDao.findById(id);

            configuration = new Configuration(test); // fixme: loop
            configuration.setId(test_id);
            configuration.setMinutesToPass(minutes_to_pass);
            configuration.setQuestionCountToView(question_count_to_view);
            configuration.setShuffleQuestion(shuffle_question);
            configuration.setShuffleAnswer(shuffle_answer);
            configuration.setShowCorrect(show_correct);
            configuration.setTakeAgain(take_again);
            configuration.setDeleted(deleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return configuration;
    }

}

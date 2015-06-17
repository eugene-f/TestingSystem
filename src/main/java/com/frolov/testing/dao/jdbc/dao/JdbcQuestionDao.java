package com.frolov.testing.dao.jdbc.dao;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.interfaces.QuestionDao;
import com.frolov.testing.dao.jdbc.JdbcBaseDao;
import com.frolov.testing.dao.jdbc.JdbcMapper;
import com.frolov.testing.entity.test.Answer;
import com.frolov.testing.entity.test.Question;
import com.frolov.testing.entity.test.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcQuestionDao extends JdbcBaseDao<Question> implements QuestionDao, JdbcMapper<Question> {

    private static final String TABLE_NAME = "QUESTIONS";

    private static final String GET_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
            "(ID, TEST_ID, CONTENT, CORRECT_ANSWER_ID, DELETED) " +
            "VALUES (NULL, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " " +
            " WHERE ID = ?";
    private static final String UPDATE = ""; // todo: write update script
    private static final String DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " " +
            " WHERE ID = ?";
    private static final String FIND_BY_TEST_ID = "SELECT * FROM " + TABLE_NAME + " " +
            " WHERE TEST_ID = ?";

    public JdbcQuestionDao() {
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Iterable<Question> getAll() throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            throw new DaoException();
        }
//        return null;
    }

    @Override
    public Question insert(Question entity) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(INSERT)) {
            mapToStatement(entity, preparedStatement);
            preparedStatement.execute();
//            return entity; // fixme: return User with Id
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Question findById(Long id) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Question update(Question entity) throws DaoException {
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
        return false;    }

    @Override
    public Iterable<Question> findByTestId(Long id) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_TEST_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PreparedStatement mapToStatement(Question entity, PreparedStatement statement) {
        try {
            statement.setLong(1, entity.getTest().getId());
            statement.setString(2, entity.getContent());
            statement.setLong(3, entity.getCorrectAnswer().getId());
            statement.setBoolean(4, entity.isDeleted());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement; // fixme: if don't map, return statement
    }

    @Override
    public Question mapToEntity(ResultSet set) {
        try {
            long id = set.getLong("ID");
            long testId = set.getLong("TEST_ID");
            String content = set.getString("CONTENT");
            long correctAnswerId = set.getLong("CORRECT_ANSWER_ID");
            boolean deleted = set.getBoolean("DELETED");

            JdbcTestDao testDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcTestDao.class);
            Test test = testDao.findById(testId);

            JdbcAnswerDao answerDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcAnswerDao.class);
            Iterable<Answer> answers = answerDao.findByQuestionId(id);
            Answer correctAnswer = answerDao.findById(correctAnswerId);

            Question question = new Question(test);
            question.setId(id);
            question.setContent(content);
            question.setAnswers((List<Answer>) answers);
            question.setCorrectAnswer(correctAnswer);
            question.setDeleted(deleted);
            return question;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

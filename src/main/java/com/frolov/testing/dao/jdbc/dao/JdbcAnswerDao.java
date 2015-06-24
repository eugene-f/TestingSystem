package com.frolov.testing.dao.jdbc.dao;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.interfaces.AnswerDao;
import com.frolov.testing.dao.jdbc.NewJdbcBaseDao;
import com.frolov.testing.entity.test.Answer;
import com.frolov.testing.entity.test.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcAnswerDao extends NewJdbcBaseDao<Answer> implements AnswerDao {

    private static final String TABLE_NAME = "ANSWERS";
    private static final String INSERT = "INSERT INTO" + " " + TABLE_NAME + " " +
    "(ID, QUESTION_ID, CONTENT, CORRECT, DELETED)" + " " +
    "VALUES (NULL, ?, ?, ?, ?)";
    private static final String FIND_BY_QUESTION_ID = "SELECT * FROM " + TABLE_NAME + " " + "WHERE QUESTION_ID = ?";
    private static final String FIND_CORRECT_BY_QUESTION_ID = "SELECT * FROM " + TABLE_NAME + " " + "WHERE ID = ? AND CORRECT = TRUE";

    public JdbcAnswerDao() {
        super(TABLE_NAME, INSERT);
    }

    public JdbcAnswerDao(String tableName, String sqlInsert) {
        super(tableName, sqlInsert);
    }

    public JdbcAnswerDao(Connection connection, String tableName, String sqlInsert) {
        super(connection, tableName, sqlInsert);
    }

    @Override
    public Iterable<Answer> findByQuestionId(Long id) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_QUESTION_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Answer findCorrectByQuestionId(Long id) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_CORRECT_BY_QUESTION_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PreparedStatement mapToStatement(Answer entity, PreparedStatement statement) {
        try {
            statement.setLong(1, entity.getQuestion().getId());
            statement.setString(2, entity.getContent());
            statement.setBoolean(3, entity.isCorrect());
            statement.setBoolean(4, entity.isDeleted());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    @Override
    public Answer mapToEntity(ResultSet set) {
        try {
            long id = set.getLong("ID");
            long questionId = set.getLong("QUESTION_ID");
            String content = set.getString("CONTENT");
            boolean correct = set.getBoolean("CORRECT");
            boolean deleted = set.getBoolean("DELETED");

            JdbcQuestionDao questionDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcQuestionDao.class);
            Question question = questionDao.findById(questionId);

            Answer answer = new Answer(question);
            answer.setId(id);
            answer.setContent(content);
            answer.setCorrect(correct);
            answer.setDeleted(deleted);
            return answer;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

package com.frolov.testing.dao.jdbc.dao;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.interfaces.SessionDao;
import com.frolov.testing.dao.jdbc.JdbcAbstractBaseDao;
import com.frolov.testing.dao.jdbc.JdbcBaseDao;
import com.frolov.testing.dao.jdbc.JdbcMapper;
import com.frolov.testing.entity.test.Session;
import com.frolov.testing.entity.test.Test;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSessionDao extends JdbcAbstractBaseDao<Session> implements SessionDao {

    private static final String TABLE_NAME = "SESSIONS";

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
            "(ID, TEST_ID, STUDENT_ID, START_DATE, RESULT, FINISHED, DELETED) " +
            "VALUES (NULL, ?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_TEST_ID = "SELECT * FROM " + TABLE_NAME + " " +
            " WHERE TEST_ID = ?";
    private static final String FIND_BY_STUDENT_ID = "SELECT * FROM " + TABLE_NAME + " " +
            " WHERE STUDENT_ID = ?";

    public JdbcSessionDao() {
        super(TABLE_NAME, INSERT);
    }

    @Override
    public Iterable<Session> findByTestId(Long id) throws DaoException {
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
    public Iterable<Session> findByStudentId(Long id) throws DaoException {
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_BY_STUDENT_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PreparedStatement mapToStatement(Session entity, PreparedStatement statement) {
        try {
            statement.setLong(1, entity.getTest().getId());
            statement.setLong(2, entity.getStudent().getId());
            statement.setDate(3, (Date) entity.getStartDate()); // fixme: change correct date type
            statement.setByte(4, entity.getPercentResult());
            statement.setBoolean(5, entity.isFinished());
            statement.setBoolean(6, entity.isDeleted());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    @Override
    public Session mapToEntity(ResultSet set) {
        try {
            if (!set.next()) {
                return null;
            } else {
                long id = set.getLong("ID");
                long testId = set.getLong("TEST_ID");
                long studentId = set.getLong("STUDENT_ID");
                Date startDate = set.getDate("START_DATE");
                byte result = set.getByte("RESULT");
                boolean finished = set.getBoolean("FINISHED");
                boolean deleted = set.getBoolean("DELETED");

                JdbcTestDao testDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcTestDao.class);
                Test test = testDao.findById(testId);

                JdbcUserDao userDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcUserDao.class);
                BaseUser user = userDao.findById(studentId); // fixme: correct cast to student

                Session session = new Session(test, (Student) user, startDate);
                session.setId(id);
                session.setPercentResult(result);
                session.setFinished(finished);
                session.setDeleted(deleted);
                return session;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

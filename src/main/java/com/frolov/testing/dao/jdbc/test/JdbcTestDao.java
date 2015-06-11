package com.frolov.testing.dao.jdbc.test;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.interfaces.test.TestDao;
import com.frolov.testing.dao.jdbc.JdbcBaseDao;
import com.frolov.testing.entity.test.Discipline;
import com.frolov.testing.entity.test.Test;

import java.sql.Connection;

public class JdbcTestDao extends JdbcBaseDao<Test> implements TestDao {

    private static final String TABLE_NAME = "TESTS";
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (ID, AUTHOR_ID, COMPLETED_SESSIONS_IDS, DISCIPLINE_ID, MINUTES_TO_PASS, NAME, PUBLICATED, QUESTIONS_IDS) VALUES (NULL, ?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " WHERE ID = ?";

    public JdbcTestDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Iterable<Test> getAll() throws DaoException {
        return null;
    }

    @Override
    public Test insert(Test entity) throws DaoException {
        return null;
    }

    @Override
    public Test findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public Test update(Test entity) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        return false;
    }

    @Override
    public Iterable<Test> fintByDiscipline(Discipline discipline) throws DaoException {
        return null;
    }

    @Override
    public Iterable<Test> fintByName(String name) throws DaoException {
        return null;
    }

    @Override
    public Iterable<Test> fintByAuthorId(Long id) throws DaoException {
        return null;
    }

}

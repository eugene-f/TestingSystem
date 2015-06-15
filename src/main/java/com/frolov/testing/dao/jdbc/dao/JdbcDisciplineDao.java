package com.frolov.testing.dao.jdbc.dao;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.interfaces.DisciplineDao;
import com.frolov.testing.dao.jdbc.JdbcBaseDao;
import com.frolov.testing.dao.jdbc.JdbcMapper;
import com.frolov.testing.entity.test.Discipline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDisciplineDao extends JdbcBaseDao<Discipline> implements DisciplineDao, JdbcMapper<Discipline> {

    private static final String TABLE_NAME = "DISCIPLINES";

    private static final String GET_ALL = "SELECT * FROM " + TABLE_NAME;
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
            "(ID, NAME, DELETED)" + " " +
            "VALUES (NULL, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE ID = ?";
    private static final String UPDATE = ""; // todo: write update script
    private static final String DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " " +
            "WHERE ID = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE NAME = ?";

    public JdbcDisciplineDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Iterable<Discipline> getAll() throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public Discipline insert(Discipline entity) throws DaoException {
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
    public Discipline findById(Long id) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_ID)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;    }

    @Override
    public Discipline update(Discipline entity) throws DaoException {
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
        return false;    }

    @Override
    public Discipline findByName(String name) throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(FIND_BY_NAME)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            return mapToEntity(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public PreparedStatement mapToStatement(Discipline entity, PreparedStatement statement) {
        try {
            statement.setString(1, entity.getName());
            statement.setBoolean(2, entity.isDeleted());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    @Override
    public Discipline mapToEntity(ResultSet set) {
        Discipline discipline = null;
        try {
            long id = set.getLong("ID");
            String name = set.getString("NAME");
            boolean deleted = set.getBoolean("DELETED");

            discipline = new Discipline(name);
            discipline.setId(id);
            discipline.setDeleted(deleted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discipline;
    }

}

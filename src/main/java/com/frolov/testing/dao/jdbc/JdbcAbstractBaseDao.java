package com.frolov.testing.dao.jdbc;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.entity.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class JdbcAbstractBaseDao<T extends BaseEntity> extends JdbcBaseDao<T> implements JdbcMapper<T> {

    protected static final Logger logger = LoggerFactory.getLogger(JdbcAbstractBaseDao.class);

    private final String TABLE_NAME;

    private final String GET_ALL;
    private final String INSERT;
    private final String FIND_BY_ID;
    private final String UPDATE;
    private final String DELETE_BY_ID;

    public JdbcAbstractBaseDao(String tableName, String sqlInsert) {
        this.TABLE_NAME = tableName;
        this.GET_ALL = "SELECT * FROM " + TABLE_NAME;
        this.INSERT = sqlInsert;
        this.FIND_BY_ID = "SELECT * FROM " + TABLE_NAME + " " + "WHERE ID = ?";
        this.UPDATE = ""; // todo: write update script
        this.DELETE_BY_ID = "DELETE FROM " + TABLE_NAME + " " + "WHERE ID = ?";
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Iterable<T> getAll() throws DaoException {
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ALL)) {
            ResultSet resultSet = statement.executeQuery();
            return mapToEntityList(resultSet);
        } catch (SQLException e) {
            throw new DaoException();
        }
    }

    @Override
    public T insert(T entity) throws DaoException {
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
    public T findById(Long id) throws DaoException {
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
    public T update(T entity) throws DaoException {
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

}

package com.frolov.testing.dao.jdbc.dao;

import com.frolov.testing.dao.DaoException;
import com.frolov.testing.dao.interfaces.DisciplineDao;
import com.frolov.testing.dao.jdbc.JdbcAbstractBaseDao;
import com.frolov.testing.dao.jdbc.JdbcBaseDao;
import com.frolov.testing.dao.jdbc.JdbcMapper;
import com.frolov.testing.entity.test.Discipline;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDisciplineDao extends JdbcAbstractBaseDao<Discipline> implements DisciplineDao {

    private static final String TABLE_NAME = "DISCIPLINES";

    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " " +
            "(ID, NAME, DELETED)" + " " +
            "VALUES (NULL, ?, ?)";
    private static final String FIND_BY_NAME = "SELECT * FROM " + TABLE_NAME + " " +
            "WHERE NAME = ?";

    public JdbcDisciplineDao() {
        super(TABLE_NAME, INSERT);
    }

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

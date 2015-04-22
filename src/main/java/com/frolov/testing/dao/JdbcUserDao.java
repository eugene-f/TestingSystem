package com.frolov.testing.dao;

import com.frolov.testing.entity.user.BaseUser;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcUserDao extends JdbcBaseDao<BaseUser> implements UserDao {

    private static final String TABLE_NAME = "USERS";
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + " (ID, FIRSTNAME, LASTNAME, EMAIL, PASSWORDHASH) VALUES (NULL, ?, ?, ?, ?)";

//    public JdbcUserDao(Connection connection) { // fixme: unknown constructor
//        super(connection);
//    }

    public JdbcUserDao() {
        super();
    }

    @Override
    public BaseUser findByEmail(String email) throws DaoException {
        return null;
    }

    @Override
    public BaseUser findByFirstName(String firstName) throws DaoException {
        return null;
    }

    @Override
    public BaseUser findByLastName(String lastName) throws DaoException {
        return null;
    }

    @Override
    public BaseUser findByFullName(String fullName) throws DaoException {
        return null;
    }

    @Override
    public Connection getConnection() {
        return super.getConnection();
    }

    @Override
    public void setConnection(Connection connection) {
        super.setConnection(connection);
    }

    @Override
    public BaseUser insert(BaseUser entity) throws DaoException {
        return null;
    }

    @Override
    public BaseUser findById(Long id) throws DaoException {
        return null;
    }

    @Override
    public Iterable<BaseUser> getAll() throws DaoException {
        return null;
    }

    @Override
    public BaseUser update(BaseUser entity) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteById(Long id) throws DaoException {
        return false;
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public BaseUser mapStatementToEntity(PreparedStatement preparedStatement) throws DaoException {
        return null;
    }

    @Override
    public PreparedStatement mapEntityToStatement(BaseUser entity) throws DaoException {
        return null;
    }
}

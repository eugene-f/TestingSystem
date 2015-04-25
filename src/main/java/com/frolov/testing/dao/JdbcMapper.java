package com.frolov.testing.dao;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.factory.UserFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcMapper {

    public static PreparedStatement mapUserToStatment(BaseUser user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getClass().getName());
        statement.setString(2, user.getFirstName());
        statement.setString(3, user.getLastName());
        statement.setString(4, user.getEmail());
        statement.setString(5, user.getPasswordHash());
        statement.setBoolean(6, user.isDeleted());
        return statement;
    }

    public static BaseUser mapResultToUser(ResultSet resultSet, BaseUser user) throws SQLException {
        BaseUser baseUser = null;
        resultSet.next();
        switch (resultSet.getString("ROLE")) {
            case "com.frolov.testing.entity.user.Tutor": baseUser = new Tutor(); break;
            case "com.frolov.testing.entity.user.Student": baseUser = new Student(); break;
        }
        if (baseUser != null) {
            baseUser.setId(resultSet.getLong("ID"));
            baseUser.setFirstName(resultSet.getString("FIRST_NAME"));
            baseUser.setEmail(resultSet.getString("EMAIL"));
            baseUser.setPasswordHash(resultSet.getString("PASSWORD_HASH"));
            baseUser.setDeleted(resultSet.getBoolean("DELETED"));
        }
        return baseUser;
    }

}

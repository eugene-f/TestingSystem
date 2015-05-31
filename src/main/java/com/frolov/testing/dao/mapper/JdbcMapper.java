package com.frolov.testing.dao.mapper;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static BaseUser mapResultToUser(ResultSet resultSet) throws SQLException {
        BaseUser baseUser = null;
        resultSet.next();
        switch (resultSet.getString("ROLE")) {
            case "com.frolov.testing.entity.user.Tutor": baseUser = new Tutor(
                    null, null, null, null, null, null
                    ); break;
            case "com.frolov.testing.entity.user.Student": baseUser = new Student(
                    null, null, null, null, null, null
                    ); break;
        }
        if (baseUser != null) {
            baseUser.setId(resultSet.getLong("ID"));
            baseUser.setFirstName(resultSet.getString("FIRST_NAME"));
            baseUser.setPasswordHash(resultSet.getString("PASSWORD_HASH"));
            baseUser.setDeleted(resultSet.getBoolean("DELETED"));
        }
        return baseUser;
    }

    public static List<BaseUser> map(ResultSet resultSet) throws SQLException {
        List<BaseUser> userList = new ArrayList<>();
        while (resultSet.next()) {
            userList.add(mapResultToUser(resultSet));
        }
        return userList;
    }

}

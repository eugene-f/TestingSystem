package com.frolov.testing.dao;

import com.frolov.testing.entity.user.Student;
import com.frolov.testing.factory.UserFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcMapper {

    static Student getStudentByResultSet(ResultSet resultSet) throws SQLException {
        resultSet.next();
        Student student = UserFactory.createStudent();
        student.setId(resultSet.getLong("ID"));
        student.setFirstName(resultSet.getString("FIRSTNAME"));
        student.setLastName(resultSet.getString("LASTNAME"));
        student.setEmail(resultSet.getString("EMAIL"));
        student.setPasswordHash(resultSet.getString("PASSWORDHASH"));
        return student;
    }

}

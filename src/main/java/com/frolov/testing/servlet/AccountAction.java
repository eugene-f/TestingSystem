package com.frolov.testing.servlet;

import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.JdbcUserDao;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.factory.UserFactory;

public class AccountAction {

    private static void addUserToDatabase(BaseUser user) {
        DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcUserDao.class).insert(user);
//        new JdbcUserDao().insert(user);
    }

    private static void addUserToMemory(BaseUser user) {
        TestingSystem.USER_LIST.add(user);
    }

    private static void setCurrentUserToMemory(BaseUser user) {
        TestingSystem.CURRENT_USER = user;
    }

    static boolean checkUserByEmail(String email) {
        return getUserByEmail(email) != null;
    }

    static BaseUser getUserByEmail(String email) {
//        return getUserByEmailFromMemory(email);
        return getUserByEmailFromDatabase(email);
    }

    private static BaseUser getUserByEmailFromMemory(String email) {
        for (BaseUser user : TestingSystem.USER_LIST) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    private static BaseUser getUserByEmailFromDatabase(String email) {
        JdbcUserDao jdbcUserDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcUserDao.class); // todo: up
        return jdbcUserDao.findByEmail(email);
    }

    static boolean checkPasswordByUser(BaseUser user, String password) {
        return user.getPasswordHash().equals(password);
    }

    static boolean login(String email, String password) {
//        BaseUser user = getUserByEmailFromMemory(email);
//        if (user != null) {
        if (checkUserByEmail(email)) {
            BaseUser user = getUserByEmailFromDatabase(email);
            if (checkPasswordByUser(user, password)) {
                setCurrentUserToMemory(user); // User is validated
            } // Incorrect password
        } // User not fond
        return false;
    }

    static BaseUser createUser(String firstName, String lastName, String email, String password, String userType) {
        BaseUser user = null;
        switch (userType) {
            case "tutor": user = UserFactory.createTutor(); break;
            case "student": user = UserFactory.createStudent(); break;
            default: break; // return;
        }
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPasswordHash(password);
            switch (userType) {
                case "tutor": TestingSystem.PLATFORM.getTutors().add((Tutor) user); break;
                case "student": TestingSystem.PLATFORM.getStudents().add((Student) user); break;
                default: break; // return;
            }
            addUserToMemory(user);
            addUserToDatabase(user);
            setCurrentUserToMemory(user);
        }
        return user;
    }

}

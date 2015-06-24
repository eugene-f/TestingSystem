package com.frolov.testing.action;

import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.jdbc.dao.JdbcUserDao;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.factory.UserFactory;
import com.frolov.testing.servlet.TestingSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Account {

    private static final Logger logger = LoggerFactory.getLogger(Account.class);
    private static final JdbcUserDao JDBC_USER_DAO = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcUserDao.class);
    public static BaseUser currentUser = null;

    public static boolean login(String email, String password) {
        BaseUser user = dbGetUserByEmail(email);
        if (user != null) {
            if (checkPasswordByUser(user, password)) {
                currentUser = user;
                logger.info("Пользователь вошел в систему");
                return true;
            } else {
                logger.info("Не верный пароль");
            }
        } else {
            logger.info("Такого пользователя не существует");
        }
        return false;
    }

    public static boolean checkUserByEmail(String email) {
        return dbGetUserByEmail(email) != null;
    }

    public static BaseUser dbGetUserByEmail(String email) {
        return JDBC_USER_DAO.findByEmail(email);
    }

    static boolean checkPasswordByUser(BaseUser user, String password) {
        return user.getPasswordHash().equals(password);
    }

    private static void dbInsertUser(BaseUser user) {
        JDBC_USER_DAO.insert(user);
    }

    public static BaseUser createUser(String firstName, String lastName, String email, String password, String userType) {
        BaseUser user = null;
        switch (userType) {
            case "tutor": user = UserFactory.createTutor(); break;
            case "student": user = UserFactory.createStudent(); break;
            // return;
        }
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPasswordHash(password);
            switch (userType) {
                case "tutor": TestingSystem.PLATFORM.getTutors().add((Tutor) user); break;
                case "student": TestingSystem.PLATFORM.getStudents().add((Student) user); break;
                default: break; // return;
            }
//            addUserToMemory(user);
            dbInsertUser(user);
//            setCurrentUserToMemory(user);
        }
        return user;
    }

}

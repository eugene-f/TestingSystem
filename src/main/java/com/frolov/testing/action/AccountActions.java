package com.frolov.testing.action;

import com.frolov.testing.Cookies;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.jdbc.dao.JdbcUserDao;
import com.frolov.testing.entity.user.Admin;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.entity.user.UserType;
import org.boon.Boon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AccountActions {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountActions.class);
    private static final JdbcUserDao JDBC_USER_DAO = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcUserDao.class);

    public static BaseUser dbGetUserByEmail(String email) {
        return JDBC_USER_DAO.findByEmail(email);
    }

    private static void dbInsertUser(BaseUser user) {
        JDBC_USER_DAO.insert(user);
    }

    public static boolean login(String email, String password) {
        BaseUser user = dbGetUserByEmail(email);
        LOGGER.info(Boon.toPrettyJson(user));
        if (user != null) {
            if (checkPasswordByUser(user, password)) {
                Cookies.setCurrentUser(user);
                LOGGER.info("User login");
                return true;
            } else {
                LOGGER.info("Incorrect password");
            }
        } else {
            LOGGER.info("User not found");
        }
        return false;
    }

    public static boolean checkUserByEmail(String email) {
        return dbGetUserByEmail(email) != null;
    }

    static boolean checkPasswordByUser(BaseUser user, String password) {
        return user.getPasswordHash().equals(password);
    }

    public static BaseUser createUser(UserType type, String firstName, String lastName, String email, String password) {
        BaseUser user;
        switch (type) {
            case Admin: user = new Admin(email, password); break;
            case Tutor: user = new Tutor(email, password, null); break;
            case Student: user = new Student(email, password, null); break;
            default: return null;
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
//        user.setPasswordHash(password);
        dbInsertUser(user);
        return user;
    }

}

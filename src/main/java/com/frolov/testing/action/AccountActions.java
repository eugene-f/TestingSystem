package com.frolov.testing.action;

import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.jdbc.dao.JdbcUserDao;
import com.frolov.testing.entity.user.Admin;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.entity.user.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AccountActions {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountActions.class);
    private static final JdbcUserDao JDBC_USER_DAO = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcUserDao.class);

    public static BaseUser currentUser = null;

    public static BaseUser dbGetUserByEmail(String email) {
        return JDBC_USER_DAO.findByEmail(email);
    }

    private static void dbInsertUser(BaseUser user) {
        JDBC_USER_DAO.insert(user);
    }

    public static boolean login(String email, String password) {
        BaseUser user = dbGetUserByEmail(email);
        if (user != null) {
            if (checkPasswordByUser(user, password)) {
                setCurrentUser(user);
                LOGGER.info("Пользователь вошел в систему");
                return true;
            } else {
                LOGGER.info("Не верный пароль");
            }
        } else {
            LOGGER.info("Такого пользователя не существует");
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
        BaseUser user = null;
        switch (type) {
            case Admin: user = new Admin(email, password); break;
            case Tutor: user = new Tutor(email, password, null); break;
            case Student: user = new Student(email, password, null); break;
            // return;
        }
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPasswordHash(password);
            dbInsertUser(user);
            setCurrentUser(user);
        }
        return user;
    }

    public static BaseUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(BaseUser currentUser) {
        AccountActions.currentUser = currentUser;
    }

}

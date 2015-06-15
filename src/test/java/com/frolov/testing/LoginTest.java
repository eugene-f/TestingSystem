package com.frolov.testing;

import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.jdbc.dao.JdbcTestDao;
import com.frolov.testing.dao.jdbc.dao.JdbcUserDao;
import com.frolov.testing.entity.user.Admin;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.action.Account;
import com.frolov.testing.factory.TestFactory;
import com.frolov.testing.servlet.TestingSystem;
import com.thedeanda.lorem.Lorem;
import org.boon.Boon;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void login() {
        BaseUser user = new Tutor("Robert_Ray@gmail.com", null);
        user.setPasswordHash("qwerty");
        user.setFirstName("Robert");
        user.setLastName("Ray");
        TestingSystem.USER_LIST.add(user);
        assertTrue(Account.checkUserByEmail(user.getEmail()));
    }

    @Test
    public void addUser() {
        JdbcUserDao userDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc)
                .create(JdbcUserDao.class);

        Admin admin = new Admin("admin@tessys.com");
        admin.setId(null);
        admin.setFirstName(Lorem.getFirstName());
        admin.setLastName(Lorem.getLastName());
        admin.setPasswordHash("qwerty");
        admin.setDeleted(false);

        userDao.insert(admin);
    }

    @Test
    public void getUsers() {
        JdbcUserDao userDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc)
                .create(JdbcUserDao.class);

        Iterable<BaseUser> all = userDao.getAll();
        for (BaseUser user : all) {
            System.out.println(Boon.toPrettyJson(user));
        }
    }

    @Test
    public void addTest() {
        com.frolov.testing.entity.test.Test test = TestFactory.createTest();

        DaoFactory instance = DaoFactory.getInstance(DaoFactory.Type.Jdbc);
        JdbcTestDao jdbcTestDao = instance.create(JdbcTestDao.class);
        jdbcTestDao.insert(test);
    }

}

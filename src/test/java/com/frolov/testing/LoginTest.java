package com.frolov.testing;

import com.frolov.testing.connection.ConnectionPool;
import com.frolov.testing.dao.DaoFactory;
import com.frolov.testing.dao.jdbc.dao.JdbcAnswerDao;
import com.frolov.testing.dao.jdbc.dao.JdbcUserDao;
import com.frolov.testing.entity.test.Answer;
import com.frolov.testing.entity.test.Question;
import com.frolov.testing.entity.user.Admin;
import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.action.AccountActions;
import com.thedeanda.lorem.Lorem;
import org.boon.Boon;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void connPool() {
        JdbcUserDao dao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcUserDao.class);
        Connection connection = ConnectionPool.getInstance().getConnection();
        dao.setConnection(connection);

        for (int i = 0; i <=5; i++) {
            Iterable<BaseUser> all = dao.getAll();
            for (BaseUser user : all) {
                System.out.println(Boon.toPrettyJson(user));
            }
        }

    }

    @Test
    public void login() {
        BaseUser user = new Tutor("Robert_Ray@gmail.com", null);
        user.setPasswordHash("qwerty");
        user.setFirstName("Robert");
        user.setLastName("Ray");
        assertTrue(AccountActions.checkUserByEmail(user.getEmail()));
    }

    @Test
    public void addUser() {
        JdbcUserDao userDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc)
                .create(JdbcUserDao.class);

        Admin admin = new Admin("admin1@tessys.com", "qwerty");
        admin.setId(null);
        admin.setFirstName(Lorem.getFirstName());
        admin.setLastName(Lorem.getLastName());
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
    public void addAnswer() {
        Question question = new Question(null);
        question.setId(ConstantContainer.RANDOM.nextLong());

        Answer answer = new Answer(question);
        answer.setId(ConstantContainer.RANDOM.nextLong());
        answer.setContent(Lorem.getWords(3, 5));
        answer.setCorrect(ConstantContainer.RANDOM.nextBoolean());
        answer.setDeleted(ConstantContainer.RANDOM.nextBoolean());

        JdbcAnswerDao answerDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcAnswerDao.class);
        answerDao.insert(answer);
    }

    @Test
    public void getAnswer() {
        JdbcAnswerDao answerDao = DaoFactory.getInstance(DaoFactory.Type.Jdbc).create(JdbcAnswerDao.class);

        Iterable<Answer> all = answerDao.getAll();
        for (Answer answer : all) {
            System.out.println(Boon.toPrettyJson(answer));
        }
    }

    @Test
    public void testJdbcDao() {
        DaoFactory instance = DaoFactory.getInstance(DaoFactory.Type.Jdbc);
        JdbcUserDao jdbcUserDao = instance.create(JdbcUserDao.class);
        jdbcUserDao.setConnection(jdbcUserDao.getConnection());
        BaseUser byEmail = jdbcUserDao.findByEmail("Ethan_Nash@gmail.com");
        System.out.println(Boon.toPrettyJson(byEmail));
    }

    @Test
    public void testConnectionPool() {
        ConnectionPool instance1 = ConnectionPool.getInstance();
        ConnectionPool instance2 = ConnectionPool.getInstance();
        ConnectionPool instance3 = ConnectionPool.getInstance();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance3.hashCode());
        System.out.println(instance1.equals(instance3));

        try {
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
            instance1.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

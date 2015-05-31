package com.frolov.testing;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.action.Account;
import com.frolov.testing.servlet.TestingSystem;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void login() {

        BaseUser user = new Tutor(
                null, "Robert", "Ray", "Robert_Ray@gmail.com", "qwerty", null
        );
        TestingSystem.USER_LIST.add(user);
        assertTrue(Account.checkUserByEmail(user.getEmail()));

    }

}

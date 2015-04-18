package com.frolov.testing;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.servlet.Login;
import com.frolov.testing.servlet.TestingSystem;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class LoginTest {

    @Test
    public void login() {

        BaseUser user = new Tutor();
        user.setId(1);
        user.setFirstName("Robert");
        user.setLastName("Ray");
        user.setEmail("Robert_Ray@gmail.com");
        user.setPasswordHash("0123456789");
        user.setDeleted(false);

        TestingSystem.USER_LIST.add(user);

        assertTrue(Login.checkUser("Robert_Ray@gmail.com", "0123456789"));

    }

}

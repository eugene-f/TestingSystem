package com.frolov.testing.servlet;

import com.frolov.testing.entity.user.BaseUser;
import com.frolov.testing.entity.user.Student;
import com.frolov.testing.entity.user.Tutor;
import com.frolov.testing.factory.UserFactory;

public class AccountUtil {

    static BaseUser getUserByEmail(String email) {
        for (BaseUser user : TestingSystem.USER_LIST) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    static boolean checkPasswordByUser(BaseUser user, String password) {
        return user.getPasswordHash().equals(password);
    }

    static boolean checkUserAndPassword(String email, String password) {
        BaseUser user = getUserByEmail(email);
        if (user != null) {
            if (checkPasswordByUser(user, password)) {
                TestingSystem.CURRENT_USER = user;
                // User is validated
                return true;
            } else {
                // Incorrect password
                return false;
            }
        } else {
            // User not fond
            return false;
        }
    }

    static BaseUser createUser(String firstName, String lastName, String email, String password, String userType) {
        BaseUser user = null;
        switch (userType) {
            case "tutor":
                user = UserFactory.createTutor();
                break;
            case "student":
                user = UserFactory.createStudent();
                break;
            default:
                break;
        }
        if (user != null) {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPasswordHash(password);
            switch (userType) {
                case "tutor":
                    TestingSystem.PLATFORM.getTutors().add((Tutor) user);
                    break;
                case "student":
                    TestingSystem.PLATFORM.getStudents().add((Student) user);
                    break;
                default:
                    break;
            }
            TestingSystem.USER_LIST.add(user);
        }
        return user;
    }

}

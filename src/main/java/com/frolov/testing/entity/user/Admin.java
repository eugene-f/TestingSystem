package com.frolov.testing.entity.user;

public class Admin extends BaseUser {

    private static final UserType TYPE = UserType.Admin;

    public Admin(String email, String password) {
        super(TYPE, email, password);
    }

}

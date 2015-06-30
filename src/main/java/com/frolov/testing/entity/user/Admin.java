package com.frolov.testing.entity.user;

/**
 * Производит предворительную регистрацию тьюторов в системе
 */
public class Admin extends BaseUser {

    private static final UserType TYPE = UserType.Admin;

    public Admin(String email) {
        super(TYPE, email);
    }

}

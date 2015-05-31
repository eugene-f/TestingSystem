package com.frolov.testing.entity.user;

/**
 * Производит предворительную регистрацию тьюторов в системе
 */
public class Admin extends BaseUser {

    public Admin(Long id, String firstName, String lastName, String email, String passwordHash) {
        super(id, firstName, lastName, email, passwordHash);
    }

}

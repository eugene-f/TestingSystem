package com.frolov.testing.entity.user;

/**
 * Производит предворительную регистрацию тьюторов в системе
 */
public class Admin extends BaseUser {

    private static final Type type = Type.Admin;

    public Admin(Long id, String email) {
        super(id, email);
    }

    public Admin(Long id, String email, String passwordHash) {
        super(id, email, passwordHash);
    }

    public Admin(Long id, String email, String firstName, String lastName, String passwordHash) {
        super(id, email, firstName, lastName, passwordHash);
    }

    public static Type getType() {
        return type;
    }

}

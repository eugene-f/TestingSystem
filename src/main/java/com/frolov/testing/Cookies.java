package com.frolov.testing;

import com.frolov.testing.entity.user.BaseUser;

public abstract class Cookies {

    public static BaseUser currentUser = null;

    public static BaseUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(BaseUser currentUser) {
        Cookies.currentUser = currentUser;
    }
}

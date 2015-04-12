package com.frolov.testingsystem.entities.user;

import java.util.UUID;

public abstract class BaseUser {

    public int id;
    public UUID uuid;
    public String firstName;
    public String lastName;
    public String email;
    public String passwordHash;

}
package com.frolov.testing.entity.user;

import com.frolov.testing.entity.BaseEntity;

/**
 * Пользователь системы
 * Разделяется на несколько типов:
 * --- Администратор = регистрирует тьюторов, управляет системой
 * --- Тьютор = создает тесты, просматривает результаты
 * --- Студент = проходит тестирование
 */
public abstract class BaseUser extends BaseEntity {

    // todo: make synchronized registration
    private final UserType type;
    private final String email; // todo: rename to 'login'
    private String firstName;
    private String lastName;
    private String passwordHash;

    public BaseUser(UserType type, String email) {
        this.type = type;
        this.email = email;
    }

    public BaseUser(UserType type, String email, String passwordHash) {
        this.type = type;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public UserType getType() {
        return type;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

}

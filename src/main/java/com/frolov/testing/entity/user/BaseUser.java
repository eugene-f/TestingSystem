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

    private final String email; // todo: make synchronized registration
    private String firstName;
    private String lastName;
    private String passwordHash;

    public BaseUser(Long id, String email) { // todo: delete
        super(id);
        this.email = email;
    }

    public BaseUser(Long id, String email, String passwordHash) { // todo: delete
        super(id);
        this.email = email;
        this.passwordHash = passwordHash;
    }

    public BaseUser(Long id, String email, String firstName, String lastName, String passwordHash) {
        super(id);
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
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

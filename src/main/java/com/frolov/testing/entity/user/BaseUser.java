package com.frolov.testing.entity.user;

import com.frolov.testing.entity.BaseEntity;

import java.util.UUID;

/**
 * Пользователь системы
 * Разделяется на несколько типов:
 * --- Администратор = регистрирует тьюторов и лаборантов
 * --- Тьютор = создает тесты, просматривает результаты
 * --- Лаборант = просматривает результаты // todo: добавить
 * --- Студент = проходит тестирование
 */
public abstract class BaseUser extends BaseEntity {

    private String firstName;
    private String lastName;
    private final String email; // todo: make synchronized registration
    private String passwordHash;

    public BaseUser(Long id, String firstName, String lastName, String email, String passwordHash) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passwordHash = passwordHash;
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

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

}

package com.frolov.testing.entity;

import java.util.UUID;

/**
 * Базовая сущьность от которой наследуютсе другие сущьности системы
 */
public abstract class BaseEntity {

    private final UUID uuid = UUID.randomUUID();
    private Long id;
    private boolean deleted = false;

    public BaseEntity(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}

package com.frolov.testing.entity;

import java.util.UUID;

public abstract class BaseEntity {

    private final UUID uuid = UUID.randomUUID();
    private Integer id = null;
    private boolean deleted = false;

    public UUID getUuid() {
        return uuid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}

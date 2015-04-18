package com.frolov.testing.entity;

import java.util.UUID;

public abstract class BaseEntity {

    protected final UUID uuid = UUID.randomUUID();
    protected int id;
    private boolean deleted = false;

    public UUID getUuid() {
        return uuid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}

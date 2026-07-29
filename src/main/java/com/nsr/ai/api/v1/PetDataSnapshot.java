package com.nsr.ai.api.v1;

import java.util.UUID;

/**
 * Represents a snapshot of a pet's data at a specific moment.
 * Part of the V1 Legacy system, maintained for backward compatibility.
 */
public class PetDataSnapshot {
    private final UUID owner;
    private final String data;

    public PetDataSnapshot(UUID owner, String data) {
        this.owner = owner;
        this.data = data;
    }

    public UUID getOwner() { return owner; }
    public String getData() { return data; }
}

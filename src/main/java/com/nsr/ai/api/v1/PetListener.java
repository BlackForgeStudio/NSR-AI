package com.nsr.ai.api.v1;

/**
 * Listener interface for pet-related events.
 * Part of the V1 Legacy system, maintained for backward compatibility.
 * @since upcoming (Experimental)
 */
public interface PetListener {
    void onPetEvent(PetDataSnapshot petData);
}

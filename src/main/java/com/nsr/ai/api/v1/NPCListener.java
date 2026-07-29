package com.nsr.ai.api.v1;

import org.bukkit.entity.Player;

/**
 * Listener interface for NPC-related events.
 * Part of the V1 Legacy system, maintained for backward compatibility.
 * @since upcoming (Experimental)
 */
public interface NPCListener {
    void onNPCInteract(Player player, String npcName);
}

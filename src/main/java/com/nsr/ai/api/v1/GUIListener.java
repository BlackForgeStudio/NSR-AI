package com.nsr.ai.api.v1;

import org.bukkit.entity.Player;

/**
 * Listener interface for GUI-related events.
 * Part of the V1 Legacy system, maintained for backward compatibility.
 * @since upcoming (Experimental)
 */
public interface GUIListener {
    void onGUIEvent(Player player, String eventType);
}

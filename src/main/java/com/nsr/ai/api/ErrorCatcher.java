package com.nsr.ai.api;

import org.bukkit.entity.Player;

public interface ErrorCatcher {
    /**
     * Called asynchronously whenever an AI API error, NSR-AI runtime error, or custom error occurs.
     * Addons can inspect the error, edit the message sent to the player,
     * save it to an error.log file, or perform custom actions.
     *
     * @param player       The player who triggered the action (can be null).
     * @param errorSource  The source of the error (e.g., "Gemini", "Claude", "OpenAI", "NSR-AI Runtime", "Custom").
     * @param errorMessage The original error message from NSR-AI.
     * @param exception    The underlying exception/throwable (can be null).
     * @return The modified error message to send to the player, null to keep the default message, or "" (empty string) to suppress sending any message.
     */
    String onError(Player player, String errorSource, String errorMessage, Throwable exception);
}

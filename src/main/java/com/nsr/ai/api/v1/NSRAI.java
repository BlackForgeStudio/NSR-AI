package com.nsr.ai.api.v1;

import com.nsr.ai.api.NSRaiAPI;
import com.nsr.ai.api.AIAddon;
import org.bukkit.entity.Player;
import java.util.Map;

/**
 * @deprecated Use {@link NSRaiAPI} directly. This class is kept for v1 backward compatibility.
 */
@Deprecated
public class NSRAI {

    public static void sendAIMessage(Player player, String message) {
        NSRaiAPI.sendMsg(player, message).execute();
    }

    public static void registerAddon(AIAddon addon) {
        NSRaiAPI.registerAddon(addon);
    }

    public static void addKnowledgeEntry(Player player, String keyword, String aiGeneratedHeading, String messageContent) {
        NSRaiAPI.addKnowledgeEntry(keyword, aiGeneratedHeading, messageContent);
    }

    public static String removeKnowledgeEntry(Player player, String key) {
        return NSRaiAPI.removeKnowledgeEntry(key);
    }

    public static Map<String, String> getKnowledgeBase(Player player) {
        return NSRaiAPI.getAllKnowledge();
    }

    public static Map<String, String> getPetInfo(Player player) {
        com.nsr.ai.api.AIPet pet = NSRaiAPI.getPet(player, null);
        if (pet != null) {
            java.util.Map<String, String> info = new java.util.HashMap<>();
            info.put("name", pet.getName());
            info.put("type", pet.getType());
            info.put("mood", pet.getMood());
            info.put("bond", String.valueOf(pet.getBond()));
            info.put("hunger", String.valueOf(pet.getHunger()));
            info.put("level", String.valueOf(pet.getLevel()));
            return info;
        }
        return java.util.Collections.emptyMap();
    }

    public static boolean tamePet(Player player, String petType) {
        return false; // Taming pet via v1 is not directly supported in v3
    }
}

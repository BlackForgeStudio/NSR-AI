package com.nsr.ai.api.v1;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

/**
 * Interface for addons to provide custom GUI definitions.
 * Part of the V1 Legacy system, maintained for backward compatibility.
 */
public interface CustomGUIProvider {
    Inventory createInventory(Player player);
    void handleClick(InventoryClickEvent event);
    String getTitle();
    int getSize();
}

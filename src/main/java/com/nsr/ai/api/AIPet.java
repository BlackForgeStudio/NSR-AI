package com.nsr.ai.api;

import java.util.UUID;

public class AIPet {
    private final String name;
    private final String type;
    private final UUID owner;
    private String nickname;
    private int bond;
    private int hunger;
    private int level;
    private double health;
    private String mood;
    private String personality;

    public AIPet(String name, String type, UUID owner) {
        this.name = name;
        this.type = type;
        this.owner = owner;
    }

    /**
     * Gets the internal immutable identifier of the pet.
     * @return The internal name.
     */
    public String getName() { return name; }
    public String getType() { return type; }
    public UUID getOwner() { return owner; }
    
    /**
     * Gets the display nickname set by the owner. May be null if no nickname is set.
     * @return The display nickname.
     */
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    
    public int getBond() { return bond; }
    public void setBond(int bond) { 
        this.bond = Math.max(0, Math.min(100, bond)); 
    }
    
    public int getHunger() { return hunger; }
    public void setHunger(int hunger) { 
        this.hunger = Math.max(0, Math.min(100, hunger)); 
    }
    
    public int getLevel() { return level; }
    public void setLevel(int level) { 
        this.level = Math.max(1, level); 
    }
    
    public double getHealth() { return health; }
    public void setHealth(double health) { 
        if (health < 0 || Double.isNaN(health)) throw new IllegalArgumentException("Health must be >= 0");
        this.health = health; 
    }
    
    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }
    
    public String getPersonality() { return personality; }
    public void setPersonality(String personality) { this.personality = personality; }
}

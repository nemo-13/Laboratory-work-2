package ork;

import gear.*; 

public class Ork {
    private String name;
    private Weapon weapon;
    private Armor armor;
    private Banner banner;
    private int strength;
    private int agility;
    private int intellect;
    private int health;
    private String tribe;
    private OrkType type;

    public Ork(String name, Weapon weapon, Armor armor, Banner banner,
               int strength, int agility, int intellect, int health,
               String tribe, OrkType type) {
        this.name = name;
        this.weapon = weapon;
        this.armor = armor;
        this.banner = banner;
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.health = health;
        this.tribe = tribe;
        this.type = type;
    }

    public String getName() { return name; }
    public Weapon getWeapon() { return weapon; }
    public Armor getArmor() { return armor; }
    public Banner getBanner() { return banner; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntellect() { return intellect; }
    public int getHealth() { return health; }
    public String getTribe() { return tribe; }
    public OrkType getType() { return type; }
    
    @Override
    public String toString() {
        return name;
    }
}
package ork;

import com.github.javafaker.Faker;
import gear.*;

public class OrkBuilder {
    private String name;
    private String tribe;
    private Weapon weapon;
    private Armor armor;
    private Banner banner;
    private int strength;
    private int agility;
    private int intellect;
    private int health;
    private OrkType type = OrkType.BASIC;
    private final Faker faker = new Faker();

    public OrkBuilder withName() {
        this.name = faker.lordOfTheRings().character();
        return this;
    }

    public OrkBuilder withTribe(String tribe) {
        this.tribe = tribe;
        applyTribeModifiers();
        return this;
    }

    public OrkBuilder withWeapon(Weapon weapon) {
        this.weapon = weapon;
        return this;
    }

    public OrkBuilder withArmor(Armor armor) {
        this.armor = armor;
        return this;
    }

    public OrkBuilder withBanner(Banner banner) {
        this.banner = banner;
        return this;
    }
    
    public OrkBuilder withType(OrkType type) {
        this.type = type;
        return this;
    }

    private void applyTribeModifiers() {
        switch (tribe) {
            case "Mordor":
                strength = (int) ((Math.random() * 130));
                agility = (int) (Math.random() * 70);
                intellect = (int) (Math.random() * 50);
                break;
            case "Dol Guldur":
                strength = (int) (Math.random() * 100);
                agility = (int) (Math.random() * 100);
                intellect = (int) (Math.random() * 50);
                break;
            case "Misty Mountains":
                strength = (int) (Math.random() * 100);
                agility = (int) (Math.random() * 130);
                intellect = (int) (Math.random() * 35);
                break;
            default:
                throw new IllegalArgumentException("Unknown tribe: " + tribe);
        }

        health = (int) (Math.random() * 150) + 50;
    }

    public Ork build() {
        if (tribe == null) {
            throw new IllegalStateException("Tribe is not specified!");
        }
        if (weapon == null || armor == null || banner == null) {
            throw new IllegalStateException("Gear is not fully configured!");
        }
        return new Ork(name, weapon, armor, banner, strength, agility, intellect, health, tribe, type);
    }
}

package ork;

import gear.*;

public class OrkDirector {
    public Ork createOrk(OrkBuilder builder, OrkType type) {
        switch (type) {
            case BASIC:
                return createBasicOrk(builder);
            case LEADER:
                return createLeaderOrk(builder);
            case SCOUT:
                return createScoutOrk(builder);
            default:
                throw new IllegalArgumentException("Unknown ork type: " + type);
        }
    }

    private Ork createBasicOrk(OrkBuilder builder) {
        return builder
                .withName()
                .withType(OrkType.BASIC)
                .build();
    }

    private Ork createLeaderOrk(OrkBuilder builder) {
        return builder
                .withName()
                .withType(OrkType.LEADER)
                .withBanner(new CustomBanner())
                .build();
    }

    private Ork createScoutOrk(OrkBuilder builder) {
        return builder
                .withName()
                .withType(OrkType.SCOUT)
                .withWeapon(new CustomWeapon())
                .withArmor(new CustomArmor())
                .build();
    }
}

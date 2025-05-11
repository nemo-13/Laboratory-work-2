package builderfactory;

import gear.DolGuldurGearFactory;
import ork.OrkBuilder;

public class DolGuldurOrkBuilderFactory implements OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        DolGuldurGearFactory gearFactory = new DolGuldurGearFactory();
        return new OrkBuilder()
                .withTribe("Dol Guldur")
                .withWeapon(gearFactory.createWeapon())
                .withArmor(gearFactory.createArmor())
                .withBanner(gearFactory.createBanner());
    }
}

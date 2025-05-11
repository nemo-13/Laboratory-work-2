package builderfactory;

import gear.MistyMountainsGearFactory;
import ork.OrkBuilder;

public class MistyMountainsOrkBuilderFactory implements OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        MistyMountainsGearFactory gearFactory = new MistyMountainsGearFactory();
        return new OrkBuilder()
                .withTribe("Misty Mountains")
                .withWeapon(gearFactory.createWeapon())
                .withArmor(gearFactory.createArmor())
                .withBanner(gearFactory.createBanner());
    }
}
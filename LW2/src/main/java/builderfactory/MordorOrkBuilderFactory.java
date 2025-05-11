package builderfactory;

import gear.MordorGearFactory;
import ork.OrkBuilder;

public class MordorOrkBuilderFactory implements OrkBuilderFactory {
    @Override
    public OrkBuilder createOrkBuilder() {
        MordorGearFactory gearFactory = new MordorGearFactory();
        return new OrkBuilder()
                .withTribe("Mordor")
                .withWeapon(gearFactory.createWeapon())
                .withArmor(gearFactory.createArmor())
                .withBanner(gearFactory.createBanner());
    }
}
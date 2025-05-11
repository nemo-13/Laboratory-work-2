package gear;

public class MistyMountainsGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() {
        return "Axe";
    }

    @Override
    public String createArmor() {
        return "Leather Armor";
    }

    @Override
    public String createBanner() {
        return "Moon Banner";
    }
}

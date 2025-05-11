package gear;

public class MordorGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() {
        return "Heavy Sword";
    }

    @Override
    public String createArmor() {
        return "Steel Armor";
    }

    @Override
    public String createBanner() {
        return "Red Eye Banner";
    }
}
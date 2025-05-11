package gear;

public class DolGuldurGearFactory implements OrcGearFactory {
    @Override
    public String createWeapon() {
        return "Spear";
    }

    @Override
    public String createArmor() {
        return "Chainmail";
    }

    @Override
    public String createBanner() {
        return "Spider Banner";
    }
}

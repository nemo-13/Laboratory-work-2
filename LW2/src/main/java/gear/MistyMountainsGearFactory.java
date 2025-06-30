package gear;

public class MistyMountainsGearFactory implements OrcGearFactory {
    @Override
    public Weapon createWeapon() {
        return new MistyMountainsWeapon();
    }

    @Override
    public Armor createArmor() {
        return new MistyMountainsArmor();
    }

    @Override
    public Banner createBanner() {
        return new MistyMountainsBanner();
    }
}

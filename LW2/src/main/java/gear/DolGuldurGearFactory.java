package gear;

public class DolGuldurGearFactory implements OrcGearFactory {
    @Override
    public Weapon createWeapon() {
        return new DolGuldurWeapon();
    }

    @Override
    public Armor createArmor() {
        return new DolGuldurArmor();
    }

    @Override
    public Banner createBanner() {
        return new DolGuldurBanner();
    }
}

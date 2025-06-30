package gear;

public class MordorGearFactory implements OrcGearFactory {
    @Override
    public Weapon createWeapon() {
        return new MordorWeapon();
    }

    @Override
    public Armor createArmor() {
        return new MordorArmor();
    }

    @Override
    public Banner createBanner() {
        return new MordorBanner();
    }
}
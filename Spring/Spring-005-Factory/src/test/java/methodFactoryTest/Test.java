package methodFactoryTest;

import methodFactory.DaggerFactory;
import methodFactory.GunFactory;
import methodFactory.Weapon;
import methodFactory.WeaponFactory;

public class Test {
    public static void main(String[] args) {
        WeaponFactory weaponFactoryD = new DaggerFactory();
        Weapon dagger = weaponFactoryD.get();
        dagger.attack();

        WeaponFactory weaponFactoryG = new GunFactory();
        Weapon gun = weaponFactoryG.get();
        gun.attack();
    }
}

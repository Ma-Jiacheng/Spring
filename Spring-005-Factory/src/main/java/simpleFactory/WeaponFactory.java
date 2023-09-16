package simpleFactory;

public class WeaponFactory {
    public static Weapon get(String weaponType){
        if ("tank".equals(weaponType)) {
            return new Tank();
        } else if ("dagger".equals(weaponType)) {
            return new Dagger();
        } else if ("fighter".equals(weaponType)) {
            return new Fighter();
        } else {
            System.out.println("暂不生产该武器！");
        }
        return null;
    }
}

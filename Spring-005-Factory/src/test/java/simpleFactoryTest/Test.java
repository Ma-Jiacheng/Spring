package simpleFactoryTest;

import simpleFactory.Weapon;
import simpleFactory.WeaponFactory;

public class Test {
    public static void main(String[] args) {
        //选择要制作的武器。对于客户来讲，武器的生产过程不需要了解，只需要向工厂索要即可
        //简单工厂模式达到了职责分离的功能，客户不需要关注生产细节，只需要进行消费即可

        //获得一辆tank
        Weapon tank = WeaponFactory.get("tank");
        assert tank != null;
        tank.attack();
        //获得一把匕首
        Weapon dagger = WeaponFactory.get("dagger");
        assert dagger != null;
        dagger.attack();
        //获得一架战斗机
        Weapon fighter = WeaponFactory.get("fighter");
        assert fighter != null;
        fighter.attack();

        System.out.println("================");

        //要求生产没有的武器
        WeaponFactory.get("AK47");
    }
}

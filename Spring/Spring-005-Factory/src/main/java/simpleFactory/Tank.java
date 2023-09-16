package simpleFactory;

public class Tank extends Weapon{
    @Override
    public void attack(){
        System.out.println("坦克发射炮弹！");
    }
}

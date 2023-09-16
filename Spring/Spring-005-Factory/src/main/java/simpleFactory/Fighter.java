package simpleFactory;

public class Fighter extends Weapon{
    @Override
    public void attack(){
        System.out.println("战斗机投掷炸弹！");
    }
}

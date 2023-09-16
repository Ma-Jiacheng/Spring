package myspring.bean;

public class GunFactory {
    //工厂方法模式中的具体角色工厂的方法是实例方法
    public Gun get(){
        return new Gun();
    }
}

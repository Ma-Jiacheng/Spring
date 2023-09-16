package proxy.service;

public class OrderServiceProxy implements OrderService{    //代理对象（代理对象要和目标对象具有相同的行为，就要实现同一个或同一些接口）

    //将目标对象作为代理对象的一个属性，这种关系叫做关联关系，比继承关系的耦合度低
    private OrderService target;
    //创建代理对象的时候，传递一个目标对象给代理对象
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() {
        long begin = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("执行耗时:" + (end - begin) + "毫秒");
    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("执行耗时:" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("执行耗时:" + (end - begin) + "毫秒");
    }
}

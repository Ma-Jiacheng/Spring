package proxy.service;

public class OrderServiceImpl implements OrderService{
    //如果此时需要测试每个方法的执行时间
    /*
    * 解决方案一：硬编码，在每一个业务接口的实现方法前后增加计时程序
    * 方法缺点：
    *   缺点一：违背OCP开闭原则
    *   缺点二：代码没有得到复用
    *
    * 解决方案二：编写业务类的子类，让子类继承业务类。对每个业务方法进行重写
    *   缺点一：虽然解决了OCP开闭原则，但是会导致程序耦合度变高（采用了继承，继承关系是一种耦合度非常高的关系）
    *   缺点二：代码没有的到复用
    *
    * 解决方案三：代理模式
    *   优点：解决了OCP问题，可以降低耦合度
    *   缺点：如果系统中接口过多，每个接口需要对应的代理类，类的数量翻倍，不易维护
    * 解决类数量爆炸问题，可以使用动态代理，添加了字节码生成技术，可以在内存中为我们动态生成一个class字节码，这个字节码就是代理类
    */

    @Override
    public void generate() {    //目标对象
//        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已生成！");
//        long end = System.currentTimeMillis();
//        System.out.println("执行耗时:" + (end - begin) + "毫秒");
    }

    @Override
    public void modify() {
//        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单信息已修改！");
//        long end = System.currentTimeMillis();
//        System.out.println("执行耗时:" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() {
//        long begin = System.currentTimeMillis();
        try {
            Thread.sleep(146);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("请查看订单详情！");
//        long end = System.currentTimeMillis();
//        System.out.println("执行耗时:" + (end - begin) + "毫秒");
    }
}

package proxy.service;

public class OrderServiceImpl implements OrderService{

    @Override
    public void generate() {    //目标对象
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单已生成！");
    }

    @Override
    public void modify() {
        try {
            Thread.sleep(456);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("订单信息已修改！");
    }

    @Override
    public void detail() {
        try {
            Thread.sleep(146);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("请查看订单详情！");
    }

    @Override
    public String getName() {
        System.out.println("getName方法执行！");
        return "张三";
    }
}

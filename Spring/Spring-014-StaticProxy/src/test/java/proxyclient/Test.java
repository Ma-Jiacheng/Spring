package proxyclient;

import proxy.service.OrderService;
import proxy.service.OrderServiceImpl;
import proxy.service.OrderServiceImplSub;
import proxy.service.OrderServiceProxy;

public class Test {
    public static void main(String[] args) {
/*        OrderService orderService = new OrderServiceImpl();
        orderService.generate();
        orderService.modify();
        orderService.detail();*/

/*        OrderServiceImplSub orderServiceImplSub = new OrderServiceImplSub();
        orderServiceImplSub.generate();
        orderServiceImplSub.modify();
        orderServiceImplSub.detail();*/

        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        //调用代理对象的方法
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }
}

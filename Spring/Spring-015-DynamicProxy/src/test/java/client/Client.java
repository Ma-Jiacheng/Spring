package client;

import proxy.service.OrderService;
import proxy.service.OrderServiceImpl;
import proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

//客户端程序
public class Client {
    public static void main(String[] args) {
        //创建目标对象
        OrderService target = new OrderServiceImpl();
        //创建代理对象
        /*
        * 1. newProxyInstance（新建代理对象），通过调用这个方法，可以创建代理对象
        *    本质上，该方法的执行做了两件事：在内存中动态的生成了一个代理类的字节码class、通过内存中生成的代理类字节码，实例化代理对象
        * 2. 关于newProxyInstance()方法的三个重要的参数，每个参数的含义，有什么用/
        *    第一个参数：ClassLoader loader 类加载器
        *    第二个参数：Class<?>[] interfaces 代理类要实现哪些接口
        *    第三个参数：InvocationHandler h 调用处理器接口，在其中编写代理类要新增的代码
        */

        //代理对象和目标对象，一定都实现了一个公共的接口，所以可以向下转型
        OrderService proxyObj = (OrderService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                                                      target.getClass().getInterfaces(),
                                                                      new TimerInvocationHandler(target));
        proxyObj.generate();

        String name = proxyObj.getName();
        System.out.println(name);
    }
}

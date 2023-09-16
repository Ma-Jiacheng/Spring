package proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//用于计时的调用处理器对象
public class TimerInvocationHandler implements InvocationHandler {
    private Object target;

    public TimerInvocationHandler(Object target) {
        //赋值给成员遍历
        this.target = target;
    }
    //当代理对象调用代理方法的时候，注册在InvocationHandler调用处理器当中的invoke方法被调用

    /*
    * invoke方法的三个参数
    *   第一个参数：Object proxy 代理对象
    *   第二个参数：Method method 目标对象的目标方法
    *   第三个参数：Object[] args 目标方法上的实参
    * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retValue = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("执行耗时:" + (end - begin) + "毫秒");

        //invoke方法的返回值，如果代理对象调用代理方法之后，需要返回结果的话，invoke必须将目标对象的目标方法的返回值继续返回
        return retValue;
    }
}

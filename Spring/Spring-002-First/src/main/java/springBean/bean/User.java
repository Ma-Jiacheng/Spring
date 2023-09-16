package springBean.bean;

public class User {
    //Spring是如何实例化对象的？
    //默认情况下Spring会通过反射机制，调用类的无参数构造方法来实例化对象
    public User() {
        System.out.println("User的无参数构造方法执行！");
    }
    /*
    实现原理：
        Class cla = Class.forName("springBean.bean.User");
        Object obj = cla.newInstance;
     */

    //如果自定义了有参数的构造方法，Java不在会默认给出无参构造方法，Spring实例化对象会失败

    /*
    public User(String s){
        System.out.println("有参构造方法执行！");
    }
    */
}

import reflect.SomeService;

public class Test {
    public static void main(String[] args) {
        //不使用反射机制调用doSome方法
        SomeService someService = new SomeService();
        /*
        * 调用一个方法，需要几个要素？
        * 第一要素：确定调用哪个对象
        * 第二要素：确定调用该对象的哪个方法
        * 第三要素：调用方法的时候传递什么参数
        * 第四要素：方法执行结束之后的返回结果
        *
        * 即使是使用反射机制调用方法，也同样需要满足该四要素
        */
        String str1 = someService.doSome("张三");
        System.out.println(str1);
        String str2 = someService.doSome("李四", 22);
        System.out.println(str2);
    }
}

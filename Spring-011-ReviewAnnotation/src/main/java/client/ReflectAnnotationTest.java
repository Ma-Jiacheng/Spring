package client;

import annotation.Component;

public class ReflectAnnotationTest {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射机制怎么读取注解
        //第一步：获取类
        Class<?> aClass = Class.forName("bean.User");
        //第二部：判断类上有没有该注解
        if (aClass.isAnnotationPresent(Component.class)) {
            //第三步：如果有，则获取类上的注解
            Component annotation = aClass.getAnnotation(Component.class);
            //第四步：访问注解属性
            System.out.println(annotation.value());
        }
    }
}

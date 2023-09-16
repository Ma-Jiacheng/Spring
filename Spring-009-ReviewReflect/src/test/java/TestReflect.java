import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestReflect {
    public static void main(String[] args) throws Exception{
        //反射机制如何调用方法

        //获取到类
        Class<?> clazz = Class.forName("reflect.SomeService");
        //获取方法
        Method doSome = clazz.getDeclaredMethod("doSome", String.class, int.class);
        //调用方法
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor();    //调用构造方法创建对象
        Object obj = declaredConstructor.newInstance();

        Object retVal = doSome.invoke(obj, "张三", 22);
        System.out.println(retVal);

        /*
        * 四要素：哪个对象？哪个方法？什么参数？什么返回值？
        * obj要素：确定哪个对象
        * doSome要素：确定哪个方法
        * “张三”, 22要素：确定什么参数
        * retVal要素：返回什么值
        */
    }
}

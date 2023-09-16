package client;

import annotation.Component;

import java.io.File;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan {
    public static void main(String[] args) {
        //创建Map集合，存放对象
        Map<String, Object> beanMap = new HashMap<>();
        //在只知道包名的情况下，扫描包中所有的类，当这个类中有@Component注解的情况下，实例化该对象，存放至Map集合中
        String packageName = "bean";
        //开始扫描程序,将包名转换为路径名
        String packagePath = packageName.replaceAll("\\.", "/");
        //使用ClassLoader类加载器，从根路径开始加载资源，获得url路径对象，即包的绝对路径
        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        String path = url.getPath();
        //获取绝对路径下的所有文件存放至files数组
        File file = new File(path);
        File[] files = file.listFiles();
        //遍历数组
        Arrays.stream(files).forEach(f -> {
            try {
                //将包名与类名组合，得到需要创建对象的类的路径
                String className = packageName + "." + f.getName().split("\\.")[0];
                //获取类
                Class<?> aClass = Class.forName(className);
                //判断该类是否包含@Component注解
                if (aClass.isAnnotationPresent(Component.class)) {
                    Component annotation = aClass.getAnnotation(Component.class);
                    //如果包含注解，则获取注解的value值，即需要创建对象的bean的id
                    String id = annotation.value();
                    //通过反射机制创建对象
                    Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
                    Object object = declaredConstructor.newInstance();
                    //将创建好的对象，按照id名存放至先前准备的Map集合中
                    beanMap.put(id, object);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(beanMap);
    }
}

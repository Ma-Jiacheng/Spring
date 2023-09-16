package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解

//该行表示注解@Component可以出现在类上以及属性上
//@Target(value = {ElementType.TYPE, ElementType.FIELD})

//该行表示注解@Component可以出现在类上
//@Target(value = {ElementType.TYPE})

//使用某个注解的时候，如果注解的属性值是value的化，value可以省略
//@Target({ElementType.TYPE})

//使用某个注解的时候，如果注解的属性值是数组，且数组中只有一个元素，大括号可以省略
//@Target(ElementType.TYPE)

//标注注解的注解，称为元注解，@Target用来修饰@Component可以出现的位置
@Target(ElementType.TYPE)
//@Retention也是一个元注解，用来标注@Component注解最终保留在class文件当中，并且可以被反射机制读取
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    //定义注解的属性
    String value();     //String是属性类型，value是属性名
}

package service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//全注解式开发
@Configuration  //代替spring.xml文件
@ComponentScan({"service"})     //组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)    //开启自Aspectj动代理，强制使用CGLIB
public class SpringConfig {
}

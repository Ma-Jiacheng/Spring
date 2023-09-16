package myspring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

/*
Bean的生命周期可粗略的分为五步：
    1. 实例化Bean（调用无参数构造方法）
    2. 给Bean属性赋值（调用set方法）
    3. 初始化Bean（调用Bean的init方法，该方法需要自己便携配置）
    4. 使用Bean
    5. 销毁Bean（调用Bean的destroy方法）
*/
public class User implements BeanNameAware, BeanFactoryAware, BeanClassLoaderAware, InitializingBean, DisposableBean {
    private String name;
    public User(){
        System.out.println("第一步：无参数构造方法执行！");
    }

    public void setName(String name) {
        System.out.println("第二步：给对象的属性赋值");
        this.name = name;
    }

    public void initBean(){
        System.out.println("第四步：初始化Bean");
    }

    public void destroyBean(){
        System.out.println("第七步：销毁Bean");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Bean的类加载器：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("生产Bean的工厂对象：" + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean的名字" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean's afterPropertiesSet方法执行！");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean's destroy方法执行！");
    }
}

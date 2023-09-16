package myspring.bean;

import org.springframework.beans.BeansException;

public class BeanPostProcessor implements org.springframework.beans.factory.config.BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第三步：执行Bean后处理器的Before方法！");
        return org.springframework.beans.factory.config.BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("第五步：执行Bean后处理器的After方法！");
        return org.springframework.beans.factory.config.BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}

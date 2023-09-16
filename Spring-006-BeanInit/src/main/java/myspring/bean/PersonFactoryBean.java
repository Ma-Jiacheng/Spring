package myspring.bean;

import org.springframework.beans.factory.FactoryBean;

public class PersonFactoryBean implements FactoryBean<Person> {

    @Override
    public Person getObject() throws Exception {
        //最终这个Bean的创建需要自己new实现
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
    //这个方法在接口中有默认实现，默认返回true，表示单例的
    //如果需要多例，修改该方法返回false
    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}

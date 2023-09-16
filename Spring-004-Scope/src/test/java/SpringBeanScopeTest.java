import myspring.bean.SpringBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeTest {
    /*
    运行结果：
      bean.SpringBean@8f4ea7c
      bean.SpringBean@8f4ea7c
      bean.SpringBean@8f4ea7c
    由结果可以看出，Spring在创建对象的时候，不是在调用Spring方法的时候创建的
    Spring在上下文初始化的时候进行实例化
    Spring创建对象是单例的，每一次调用getBean()方法，都返回那个单例对象
    */
    @Test
    public void testBeanScope(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean springBean1 = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean1);

        SpringBean springBean2 = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean2);

        SpringBean springBean3 = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean3);
    }
}

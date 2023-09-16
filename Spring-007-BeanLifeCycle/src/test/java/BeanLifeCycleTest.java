import myspring.bean.Student;
import myspring.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {
    /*
    Spring容器只对singleton的Bean进行完整生命周期管理
    如果是prototype作用域的Bean，Spring容器只负责将该Bean初始化完毕。等客户端程序获取到该Bean之后，Spring容器就不再管理该对象的生命周期
    */
    @Test
    public void testBeanLifeCycleFive(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第六步：使用Bean" + user);

        //必须手动关闭Spring容器，Spring容器才会销毁Bean
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) applicationContext;
        context.close();
    }

    @Test
    public void testRegisterBean(){
        //自己new创建的对象
        Student student = new Student();
        System.out.println(student);

        //将以上自己new创建的对象纳入Spring容器来管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean", student);

        //从Spring容器中获取对象
        Object studentBean = factory.getBean("studentBean");
        System.out.println(studentBean);
    }
}

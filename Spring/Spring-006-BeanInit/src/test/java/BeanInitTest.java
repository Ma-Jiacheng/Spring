import myspring.bean.GunFactory;
import myspring.bean.Person;
import myspring.bean.SpringBean;
import myspring.bean.Star;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInitTest {
    //Bean的实例化：通过构造方法实例化
    @Test
    public void testInitMethod01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean springBean = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean);
    }

    //Bean的实例化：通过简单工厂模式实例化
    @Test
    public void testInitBeanMethod02(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star starFactory = applicationContext.getBean("starFactory", Star.class);
        System.out.println(starFactory);
    }

    //Bean的实例化：通过工厂方法模式实例化
    @Test
    public void testInitBeanMethod03(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        GunFactory gunFactory = applicationContext.getBean("gunFactory", GunFactory.class);
        gunFactory.get();
    }

    @Test
    public void testInitBeanMethod04(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }
}

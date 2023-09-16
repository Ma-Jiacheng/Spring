import myspring.bean.Husband;
import myspring.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {
    @Test
    public void testCD(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        System.out.println(husbandBean);
        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(wifeBean);
    }

/*    @Test
    public void testCD2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        Father fatherBean = applicationContext.getBean("fatherBean", Father.class);
        System.out.println(fatherBean);
        Children childrenBean = applicationContext.getBean("childrenBean", Children.class);
        System.out.println(childrenBean);
    }*/
}

package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import resource.SpringConfig;
import resource.service.StudentService;
import spring.bean.Order;
import spring.bean.Student;
import spring.bean.User;
import spring.bean.Vip;
import spring.dao.OrderDao;
import spring.value.MyDataSource;
import spring6.service.OrderService;

import java.lang.annotation.Annotation;

public class IoCAnnotationTest {
    @Test
    public void testBeanComponent(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
        Vip vipBean = applicationContext.getBean("vip", Vip.class);
        System.out.println(vipBean);
        Order orderBean = applicationContext.getBean("orderBean", Order.class);
        System.out.println(orderBean);
        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean);
        OrderDao orderDao = applicationContext.getBean("orderDao", OrderDao.class);
        System.out.println(orderDao);
    }

    @Test
    public void testChoose(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");
    }

    @Test
    public void testDiByAnnotation(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource.toString());
    }

    @Test
    public void testAutoWired(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testResource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }

    @Test
    public void testNoXML(){
        AnnotationConfigApplicationContext Context = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentService studentService = Context.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }
}

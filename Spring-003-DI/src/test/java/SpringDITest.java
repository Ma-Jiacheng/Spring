import bean.*;
import jdbc.MyDataSource;
import jdbc.MyDataSource01;
import jdbc.MyDataSource02;
import myspring.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.CustomerService;
import service.OrderService;
import service.UserService;

public class SpringDITest {
    @Test
    //set注入
    public void testSetDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.saveUser();
    }

    @Test
    //构造注入
    public void testConstructorDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService1 = applicationContext.getBean("csBean1", CustomerService.class);
        customerService1.save();

        System.out.println("================");

        CustomerService customerService2 = applicationContext.getBean("csBean2", CustomerService.class);
        customerService2.save();

        System.out.println("=================");

        CustomerService customerService3 = applicationContext.getBean("csBean3", CustomerService.class);
        customerService3.save();
    }

    @Test
    public void testSetBean(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderService1 = applicationContext.getBean("orderServiceBean1", OrderService.class);
        orderService1.generate();

        System.out.println("=================");

        OrderService orderService2 = applicationContext.getBean("orderServiceBean2", OrderService.class);
        orderService2.generate();
    }

    @Test
    //简单数据类型注入
    public void testSimpleTypeDI(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    //数据源
    public void testMyDataSource(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }

    @Test
    //数组注入
    public void testArray(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        arrayDI food = applicationContext.getBean("arrayDI", arrayDI.class);
        System.out.println(food);
    }

    @Test
    //list、set、Map集合注入
    public void testListAndSet(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);
    }

    //注入NULL和空字符串
    @Test
    public void testNull(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean);
    }

    @Test
    public void testSymbol(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MathBean mathBean = applicationContext.getBean("mathBean", MathBean.class);
        System.out.println(mathBean);
    }

    @Test
    public void testP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Teacher teacherBean = applicationContext.getBean("teacherBean", Teacher.class);
        System.out.println(teacherBean);
    }

    @Test
    public void testC(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-c.xml");
        People peopleBean = applicationContext.getBean("peopleBean", People.class);
        System.out.println(peopleBean);
    }

    @Test
    public void testUtil(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-util.xml");
        MyDataSource01 myDataSource01 = applicationContext.getBean("myDataSource01", MyDataSource01.class);
        MyDataSource02 myDataSource02 = applicationContext.getBean("myDataSource02", MyDataSource02.class);
        System.out.println(myDataSource01);
        System.out.println(myDataSource02);
    }

    //自动装配是基于set方法的
    @Test
    public void testAutoWire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autowire.xml");
//        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
//        orderService.generate();
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        customerService.save();
    }

    @Test
    public void testProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource myDataSource = applicationContext.getBean("dataSource", MyDataSource.class);
        System.out.println(myDataSource);
    }
}

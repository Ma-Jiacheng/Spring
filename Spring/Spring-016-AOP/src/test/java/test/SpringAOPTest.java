package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.SpringConfig;
import service.UserService;

public class SpringAOPTest {
    @Test
    public void testBefore(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        //userService.login();
        //userService.logout();

        userService.generate();
    }

    @Test
    public void testNoXML(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.generate();
    }
}

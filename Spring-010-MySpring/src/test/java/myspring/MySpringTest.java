package myspring;

import myspring.bean.UserService;
import org.junit.Test;
import org.dao.myspringframework.core.ApplicationContext;
import org.dao.myspringframework.core.ClassPathXmlApplicationContext;

public class MySpringTest {
    @Test
    public void testMySpring(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");

        Object user = applicationContext.getBean("user");
        System.out.println(user);

        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}

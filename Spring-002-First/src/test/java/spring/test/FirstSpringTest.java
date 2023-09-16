package spring.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import springBean.bean.User;
import springBean.dao.userDaoImplForMySQL;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstSpringTest {
    @Test
    public void testFirstSpringCode() {
        //第一步：或取Spring容器对象
        //ApplicationContext是一个接口，在此接口下有很多实现类，其中一个是ClassPathXmlApplicationContext
        //ClassPathXmlApplicationContext专门从类路径中加载Spring配置文件中的一个上下文对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        System.out.println("=======================");

        //第二部：根据bean的id从Spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        System.out.println("=======================");

        //Spring实例化JDK中类的对象，如果bean的id不存在，会报错
        //需要输出一定格式的结果，可以使用强制类型转换
        //Date nowTimeChange = (Date) applicationContext.getBean("nowTime");

        //如果不想使用强制类型转换，也可以使用以下代码（通过第二个参数指定bean的返回类型）
        Date nowTime = applicationContext.getBean("nowTime", Date.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String NowTime = sdf.format(nowTime);
        System.out.println(NowTime);

        System.out.println("=======================");

        //以上方式对于自定义类中的方法，同样适用
        userDaoImplForMySQL userDaoBean = applicationContext.getBean("userDaoBean", userDaoImplForMySQL.class);
        userDaoBean.Save();

        System.out.println("=======================");
    }

    @Test
    public void testXmlPath(){
        //ClassPathXmlApplicationContext从类路径中加载资源
        //FileSystemXmlApplicationContext从非类路径中加载资源
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("G:/Environment/spring6.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }
    @Test
    public void testBeanFactory(){
        //ApplicationContext接口的超级父接口为BeanFactory，能够生产Bean对象的一个工厂对象
        //BeanFactory是IoC容器的顶级接口
        //Spring的IoC容器，实际上是使用了工厂模式
        //Spring底层的IoC实现模式：XML解析 + 工厂模式 + 反射机制
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }
    @Test
    public void testBeginInitBean(){
        //注意：不是在调用getBean()方法的时候创建对象，执行以下代码的时候，就会实例化对象
        //new ClassPathXmlApplicationContext("spring");

        //怎么使用log4j2记录日志信息？
        //第一步：创建日志记录器对象
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);     //获取FirstSpringTest类中的日志记录信息

        //第二部：记录日志，根据不同的日志级别输出日志
        logger.info("我是一条消息");
        logger.debug("我是一条调试信息");
        logger.error("我是一条错误信息");
    }
}

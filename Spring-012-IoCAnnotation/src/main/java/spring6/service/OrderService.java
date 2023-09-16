package spring6.service;

import org.springframework.beans.factory.annotation.Qualifier;
import spring6.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "orderService")
public class OrderService {
    //非简单类型，不能使用@Value
    //@Autowired注解使用的时候，不许要指定任何属性，直接使用这个注解即可
    //这个注解的作用是根据类型byType进行自动装配
//    @Autowired
//    private OrderDao orderDao;

    //如果有多个实现类需要注入，则不能单独使用@Autowired
    //如果需要解决该问题，则需要使用@Autowired和@Qualifier联合使用，通过名字进行注入

//    @Autowired
//    @Qualifier(value = "orderDaoImplForMySQL")
//    @Qualifier(value = "orderDaoImplForOracle")

    //@Autowired可以使用在属性上
    private OrderDao orderDao;

    //@Autowired也可以使用在setter方法上
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    //@Autowired也可以使用在构造方法上
/*  public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }*/

    //@Autowired也可以使用在构造方法的参数上
    public OrderService(@Autowired OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void generate(){
        orderDao.insert();
    }
}

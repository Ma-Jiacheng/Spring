package spring6.dao.impl;

import spring6.dao.OrderDao;
import org.springframework.stereotype.Repository;

@Repository(value = "orderDaoImplForMySQL")
public class OrderDaoImplForMySQL implements OrderDao {
    @Override
    public void insert() {
        System.out.println("MySQL正在保存订单信息......");
    }
}

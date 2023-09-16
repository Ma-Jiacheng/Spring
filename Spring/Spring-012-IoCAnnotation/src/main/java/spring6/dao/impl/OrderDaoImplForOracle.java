package spring6.dao.impl;

import org.springframework.stereotype.Repository;
import spring6.dao.OrderDao;

//@Repository(value = "orderDaoImplForOracle")
public class OrderDaoImplForOracle implements OrderDao {
    @Override
    public void insert() {
        System.out.println("Oracle正在保存订单信息......");
    }
}

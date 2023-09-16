package org.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    public void insert(){
        System.out.println("数据库正在保存用户信息...");
    }
}

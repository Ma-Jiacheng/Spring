package service;

import org.dao.UserDao;

public class UserService {
    private UserDao userDao;

    //set注入，必须提供一个set方法
    //Spring容器会调用这个set方法，给userDao赋值
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(){
        //保存用户信息到数据库
        userDao.insert();
    }
}

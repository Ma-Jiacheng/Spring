package springRevelation.service.impl;

import springRevelation.dao.UserDao;
import springRevelation.dao.impl.UserDaoImplForOracle;
import springRevelation.service.UserService;

public class UserServiceImpl implements UserService {
    //private UserDao userDao = new UserDaoImplForMySQL();

    //修改为
    private final UserDao userDao = new UserDaoImplForOracle();

    @Override
    public void deleteUser() {
        userDao.deleteById();
    }
}

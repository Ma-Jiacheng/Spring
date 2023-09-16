package springRevelation.web;

import springRevelation.service.UserService;
import springRevelation.service.impl.UserServiceImpl;

public class UserAction {
    private UserService userService = new UserServiceImpl();

    //删除用户信息的请求
    public void deleteRequest(){
        userService.deleteUser();
    }
}

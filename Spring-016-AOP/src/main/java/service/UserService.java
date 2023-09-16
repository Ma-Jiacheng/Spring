package service;

import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService {  //目标类

    public void login(){    //目标方法
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("系统正在进行身份认证...");
    }

    public void logout(){
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("正在退出系统...");
    }

    public void generate(){
        System.out.println("系统正在生成订单...");

/*        if (1 + 1== 2){
            throw new RuntimeException("运行时异常！");
        }*/
    }

}

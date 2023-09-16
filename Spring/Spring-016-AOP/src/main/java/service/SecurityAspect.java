package service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)   //使用@Order注解，为切面类进行排序，在（）编写顺序，数字越小优先级越高
public class SecurityAspect {
    @Before("execution(* service.UserService.generate(..))")
    public void beforeAdvice(){
        System.out.println("安全前置通知！");
    }
}

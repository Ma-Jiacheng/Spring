package service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component(value = "logAspect")
@Aspect     //切面类使用@Aspect注解进行标注
@Order(2)
public class LogAspect {    //切面
    //避免在每个通知注解中编写切点表达式，使用@Pointcut注解，定义通用的切点表达式
    @Pointcut("execution(* service.UserService.generate(..))")
    public void cutPoint(){
        //该方法只作为标记使用，方法名随意，不需要编写任何代码
    }

    //切面 = 通知（编写的具体增强代码） + 切点
    //切点表达式：execution(控制权限修饰符 返回值类型 全限定类名 方法名（形式参数列表） 异常)

    @Before("cutPoint()")   //@Before注解表示前置通知，（）中编写切点表达式
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("前置通知：系统开始执行！");
        //JoinPoint在Spring容器调用这个方法的时候自动传过来
        //JoinPoint的作用？
        //Signature signature = joinPoint.getSignature();获取目标方法的签名,获取一个方法的具体信息
        Signature signature = joinPoint.getSignature();
        System.out.println("目标方法签名：" + signature);

    }

    @AfterReturning("cutPoint()")
    public void afterReturningAdvice(){
        System.out.println("后置通知：系统执行结束！");
    }

    //环绕通知是范围最大的通知，在前置通知之前，在后置通知之后
/*    @Around("execution(* service.UserService.generate(..))")
    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //方法前代码
        System.out.println("环绕通知：前环绕通知！");
        //方法执行
        proceedingJoinPoint.proceed();
        //方法后代码
        System.out.println("环绕通知：后环绕通知");
    }*/

    //发生异常时执行异常通知，如果异常通知执行，后置通知及后环绕通知不再执行
/*    @AfterThrowing("execution(* service.UserService.generate(..))")
    public void afterThrowingAdvice(){
        System.out.println("异常通知！");
    }

    @After("execution(* service.UserService.generate(..))")
    public void afterAdvice(){
        System.out.println("最终通知！");
    }*/
}

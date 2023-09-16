package reflect;

public class SomeService {
    public void doSome(){
        System.out.println("doSome()方法执行！");
    }

    public String doSome(String str){
        System.out.println("doSome(String str)方法执行！");
        return str;
    }

    public String doSome(String str, int num){
        System.out.println("doSome(String str, int num)方法执行！");
        return str + num;
    }
}

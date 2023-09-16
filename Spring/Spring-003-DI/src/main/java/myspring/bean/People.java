package myspring.bean;

public class People {
    private String name;
    private int age;
    private boolean sex;

    //C命名空间注入是简化构造注入，基于构造方法

    public People(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}

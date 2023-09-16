package myspring.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Person {
    //注入list集合
    private List<String> name;
    //注入set集合
    private Set<String> address;
    //注入Map集合
    private Map<Integer, String> phone;

    public void setName(List<String> name) {
        this.name = name;
    }
    public void setAddress(Set<String> address) {
        this.address = address;
    }
    public void setPhone(Map<Integer, String> phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", address=" + address +
                ", phone=" + phone +
                '}';
    }
}

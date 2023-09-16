package myspring.bean;

import java.util.Date;

public class Teacher {
    private String name;
    private String subject;
    private Date date;

    //P命名空间注入，实际还是set注入，但是可以让Spring配置变得更简单
    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", date=" + date +
                '}';
    }
}

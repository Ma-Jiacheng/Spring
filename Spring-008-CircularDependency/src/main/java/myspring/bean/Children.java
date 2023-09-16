package myspring.bean;

public class Children {
    private String name;

    private Father father;

    public Children(String name, Father father) {
        this.name = name;
        this.father = father;
    }

    public Children() {

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", father=" + father +
                '}';
    }
}

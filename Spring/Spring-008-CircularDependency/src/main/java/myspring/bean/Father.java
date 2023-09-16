package myspring.bean;

public class Father {
    private String name;

    private Children children;

    public Father(String name, Children children) {
        this.name = name;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}

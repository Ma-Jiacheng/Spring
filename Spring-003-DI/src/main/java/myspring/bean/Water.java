package myspring.bean;

public class Water {
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}

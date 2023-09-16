package myspring.bean;

public class MathBean {
    private String result;

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MathBean{" +
                "result='" + result + '\'' +
                '}';
    }
}

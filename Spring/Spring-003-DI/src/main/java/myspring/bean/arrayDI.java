package myspring.bean;

import java.util.Arrays;

public class arrayDI {
    private String[] food;

    private Water[] water;

    public void setFood(String[] food) {
        this.food = food;
    }

    public void setWater(Water[] water) {
        this.water = water;
    }

    @Override
    public String toString() {
        return "arrayDI{" +
                "food=" + Arrays.toString(food) +
                ", water=" + Arrays.toString(water) +
                '}';
    }
}

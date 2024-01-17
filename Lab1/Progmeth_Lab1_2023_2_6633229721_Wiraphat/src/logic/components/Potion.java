package logic.components;

import java.util.Objects;

public class Potion {
//    field
    private String name;
    private int price;
    private Status increasingStatus;

//    constructor
    public Potion(String name, int price, Status increasingStatus) {
        setName(name);
        setPrice(price);
        setIncreasingStatus(increasingStatus);
    }

//    method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Potion potion = (Potion) o;
        return potion.price == price &&
                potion.increasingStatus == increasingStatus &&
                Objects.equals(potion.name, name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        if (price < 1) {
            price = 1;
        }
        this.price = price;
    }

    public Status getIncreasingStatus() {
        return this.increasingStatus;
    }

    public void setIncreasingStatus(Status increasingStatus) {
        this.increasingStatus = increasingStatus;
    }
}

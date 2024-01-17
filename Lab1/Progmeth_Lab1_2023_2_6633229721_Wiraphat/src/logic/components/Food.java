package logic.components;

import java.util.Objects;

public class Food {
//    field
    private String name;
    private int price;
    private int energy;

//    constructor
    public Food(String name,int price,int energy) {
        setName(name);
        setPrice(price);
        setEnergy(energy);
    }

//    method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return price == food.price &&
            energy == food.energy &&
            Objects.equals(name, food.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(int price) {
        if (price < 1) {
            price = 1;
        }
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void setEnergy(int energy) {
        if (energy < 1) {
            energy = 1;
        }
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

}

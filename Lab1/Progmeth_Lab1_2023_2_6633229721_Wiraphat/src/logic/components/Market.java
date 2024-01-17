package logic.components;

import java.util.ArrayList;

public class Market {
//    field
    private String name;
    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;

//    constructor
    public Market(String name) {
        this.name = name;
        this.foods = new ArrayList<>();
        this.potions = new ArrayList<>();
    }

//    method
    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    // Getter and setter for potions
    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

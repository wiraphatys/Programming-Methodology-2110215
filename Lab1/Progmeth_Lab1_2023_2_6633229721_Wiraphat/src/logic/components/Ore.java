package logic.components;

import java.util.Objects;

public class Ore {
//    field
    private String name;
    private int cost;

//    constructor
    public Ore(String name, int cost) {
        setName(name);
        setCost(cost);
    }

//    method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ore ore = (Ore) o;
        return  cost == ore.cost &&
                Objects.equals(name, ore.name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return this.cost;
    }

    public void setCost(int cost) {
        if (cost < 1) {
            cost = 1;
        }
        this.cost = cost;
    }
}

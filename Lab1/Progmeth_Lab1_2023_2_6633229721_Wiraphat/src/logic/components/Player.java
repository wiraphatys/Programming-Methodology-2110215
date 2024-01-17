package logic.components;

import exception.BadStatusException;

import java.util.ArrayList;

public class Player {
//    field
    private String name;
    private Status status;
    private int energy;
    private int money;
    private ArrayList<Food> foods = new ArrayList<>();
    private  ArrayList<Potion> potions = new ArrayList<>();
    private  ArrayList<Ore> ores = new ArrayList<>();

//    constructor
    public Player(String name, Status status) {
        if (status.getHp() < 1) {
            try {
                status.setHp(1);
            } catch (BadStatusException e) {
                throw new RuntimeException(e);
            }
        }
        setName(name);
        setStatus(status);
        setEnergy(10);
        setMoney(100);
    }

    public Player(String name, Status status, int energy, int money) {
        if (status.getHp() < 1) {
            try {
                status.setHp(1);
            } catch (BadStatusException e) {
                throw new RuntimeException(e);
            }
        }
        setName(name);
        setStatus(status);
        setEnergy(energy);
        setMoney(money);
    }

//    method
    public boolean buyOre(Ore ore) {
        if (money < ore.getCost()) return false;
        money -= ore.getCost();
        ores.add(ore);
        return true;
    }

    public void drinkPotion(int index) {
        if (index < 0 || index >= potions.size()) {
            return;
        }
        Potion potion = potions.get(index);
        try {
            status.setHp(status.getHp() + potion.getIncreasingStatus().getHp());
            status.setAttack(status.getAttack() + potion.getIncreasingStatus().getAttack());
            status.setDurability(status.getDurability() + potion.getIncreasingStatus().getDurability());
            status.setMagic(status.getMagic() + potion.getIncreasingStatus().getMagic());
        } catch (BadStatusException e) {
            throw new RuntimeException(e);
        }
        potions.remove(index);
    }

    public void eatFood(int index) {
        if (0 <= index && index < foods.size()) {
            energy += (foods.get(index)).getEnergy();
            foods.remove(index);
        }
    }

    public void sellPotion(int index) {
        if (index < 0 || index >= potions.size()) {
            return;
        }
        Potion potion = potions.get(index);
        money += potion.getPrice();
        potions.remove(index);
    }

    public void sellFood(int index) {
        if (index < 0 || index >= foods.size()) {
            return;
        }
        Food food = foods.get(index);
        money += food.getPrice();
        foods.remove(index);
    }

    public void attack(Monster monster) {
        int damage = Math.max(status.getAttack() - monster.getStatus().getDurability(), 0);

        int hp = monster.getStatus().getHp();
        try {
            monster.getStatus().setHp((hp < damage) ? 0 : hp - damage);
        } catch (BadStatusException e) {
            throw new RuntimeException(e);
        }

    }

    public void magicAttack(Monster monster) {
        int damage = status.getMagic();

        int hp = monster.getStatus().getHp();
        try {
            monster.getStatus().setHp((hp < damage) ? 0 : hp - damage);
        } catch (BadStatusException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getEnergy() {
        return this.energy;
    }

    public void setEnergy(int energy) {
        if (energy < 0) {
            energy = 0;
        }
        this.energy = energy;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            money = 0;
        }
        this.money = money;
    }

    public ArrayList<Food> getFoods() {
        return this.foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public ArrayList<Potion> getPotions() {
        return this.potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Ore> getOres() {
        return this.ores;
    }

    public void setOres(ArrayList<Ore> ores) {
        this.ores = ores;
    }
}

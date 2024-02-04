package logic.card;

import logic.player.Player;

public abstract class BaseCard {
    // field
    private String name;
    private int power;
    private int health;

    // constructor
    public BaseCard(String name, int power, int health) {
        setName(name);
        setHealth(health);
        setPower(power);
    }

    // method
    public abstract void play(Player player);

    public abstract boolean canPlay(Player player);

    public int attack(BaseCard target) {
        int leftHealth = target.getHealth() - getPower();
        target.setHealth(leftHealth);
        return (leftHealth < 0) ? -leftHealth : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = Math.max(0, power);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }
}

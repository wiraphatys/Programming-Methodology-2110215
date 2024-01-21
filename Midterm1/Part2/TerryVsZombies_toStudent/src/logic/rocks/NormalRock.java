package logic.rocks;

import logic.zombies.Zombie;

public class NormalRock {
    // field
    protected int damage;

    // constructor
    public NormalRock(int damage) {
        setDamage(damage);
    }

    // method
    public void setDamage(int damage) {
        this.damage = Math.max(0, damage);
    }

    public int getDamage() {
        return this.damage;
    }

    public int dealDamage(Zombie zombie) {
        int damageDealt = Math.max(0, getDamage() - zombie.getDefense());
        zombie.setHealth(zombie.getHealth() - damageDealt);
        return damageDealt;
    }


    public String toString() {
        return "Normal Rock (" + getDamage() + ")";
    }
}

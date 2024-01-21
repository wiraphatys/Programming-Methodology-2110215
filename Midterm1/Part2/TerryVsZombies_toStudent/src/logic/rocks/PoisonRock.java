package logic.rocks;

import logic.zombies.Zombie;

public class PoisonRock extends NormalRock {
    // field
    private int damageOverTime;

    // constructor
    public PoisonRock(int damage, int damageOverTime) {
        super(damage);
        setDamageOverTime(damageOverTime);
    }

    // method
    public void setDamageOverTime(int damageOverTime) {
        this.damageOverTime = Math.max(0, damageOverTime);
    }

    public int getDamageOverTime() {
        return this.damageOverTime;
    }

    public int dealDamage(Zombie zombie) {
        zombie.setDecay(zombie.getDecay() + this.getDamageOverTime());
        return super.dealDamage(zombie);
    }

    public String toString() {
        return "Poison Rock (" + getDamage() +", DoT = "
                +getDamageOverTime() +")";
    }
}

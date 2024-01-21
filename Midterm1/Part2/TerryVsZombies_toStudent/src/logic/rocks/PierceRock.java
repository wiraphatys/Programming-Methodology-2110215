package logic.rocks;

import logic.zombies.Zombie;

public class PierceRock extends NormalRock {
    // constructor
    public PierceRock(int damage) {
        super(damage);
    }

    // method
    public int dealDamage(Zombie zombie) {
        int damageDealt = Math.max(0, getDamage());
        zombie.setHealth(zombie.getHealth() - damageDealt);
        return damageDealt;
    }
}

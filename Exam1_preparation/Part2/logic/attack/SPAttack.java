package logic.attack;

import logic.monster.Monster;

public class SPAttack extends Attack {
    // constructor
    public SPAttack(int power, String name,boolean isLeader) {
        super(power, name, isLeader);
    }
    // method
    public int calculateDamage (Monster target) {
        int damage = this.getPower() - target.getSpecialDefense();
        damage = Math.max(0, damage);

        return damage;
    }
}

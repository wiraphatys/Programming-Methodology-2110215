package logic.monster;

import logic.attack.Attack;

public class Leader extends Monster {
    // field
    private int maxChargeTurns;
    private int currentChargeTurns;
    private boolean isGuard;

    // constructor
    public Leader(String name, int hp, int def, int sp_def, Attack attack, int chargeTurns) {
        super(name, hp, def, sp_def, attack);
        this.setMaxChargeTurns(chargeTurns);
        this.setCurrentChargeTurns(0);
    }

    public int getMaxChargeTurns() {
        return maxChargeTurns;
    }

    public void setMaxChargeTurns(int maxChargeTurns) {
        this.maxChargeTurns = maxChargeTurns;
    }

    public int getCurrentChargeTurns() {
        return currentChargeTurns;
    }

    public void setCurrentChargeTurns(int currentChargeTurns) {
        if (currentChargeTurns > getMaxChargeTurns()) currentChargeTurns = getMaxChargeTurns();
        if (currentChargeTurns < 0) currentChargeTurns = 0;
        this.currentChargeTurns = currentChargeTurns;
    }

    public boolean isGuard() {
        return isGuard;
    }

    public void setGuard(boolean guard) {
        isGuard = guard;
    }

    public boolean isReady() {
        return currentChargeTurns >= maxChargeTurns;
    }

    public int takeDamage(Attack attack) {
        int damage = attack.calculateDamage(this);
        if (isGuard) {
            return 0;
        } else {
            if (attack.isLeader()) {
                setHp(getHp() - damage);
            } else {
                setHp((int) (getHp() - Math.ceil(damage*0.5)));
            }
            if (getHp() == 0) isDead = true;
        }
        return damage;
    }
}

package item.consumption;

import item.base.BaseConsumption;
import item.usage.Healable;
import item.usage.Upgradable;

public class HealingPotion extends BaseConsumption implements Healable , Upgradable {
    // field
    private int level;
    private final int MAX_LEVEL;
    private final int[] RECOVER_PT;

    // constructor
    public HealingPotion() {
        super("HealingPotion");
        setLevel(0);
        this.MAX_LEVEL = 3;
        RECOVER_PT = new int[]{3,5,7,10};
    }

    // method
    public void setLevel(int level) {
        if (level > this.MAX_LEVEL || level < 0) level = 0;
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

    public int getMaxLevel() {
        return this.MAX_LEVEL;
    }

    public int getRecoverPoint() {
        return RECOVER_PT[level];
    }

    public String toString() {
        return getName() + " (+" + getRecoverPoint() + " HP, Level: " + getLevel() + ")";
    }
}

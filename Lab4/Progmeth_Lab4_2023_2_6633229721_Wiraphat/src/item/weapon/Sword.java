package item.weapon;

import item.base.BaseWeapon;
import item.usage.Upgradable;

public class Sword extends BaseWeapon implements Upgradable {
    // field
    private int level;
    private final int MAX_LEVEL;
    private final int[] ATT;

    // constructor
    public Sword() {
        super("Sword", 15, 1);
        setLevel(0);
        this.MAX_LEVEL = 3;
        this.ATT = new int[]{3,5,8,12};
    }

    // method
    public int getAtt() {
        return ATT[level];
    }

    public void setLevel(int Level) {
        if (Level > this.MAX_LEVEL || Level < 0) Level = 0;
        this.level = Level;
    }

    public int getLevel() {
        return this.level;
    }

    public int getMaxLevel() {
        return this.MAX_LEVEL;
    }

    public String toString() {
        return getName() + " (Att: " + getAtt() + ", Range: " + getRange() + ", Level: " + getLevel() + ", " + getDurability() + " uses left)";
    }
}

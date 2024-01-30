package item.armor;

import item.base.BaseArmor;

public class Suit extends BaseArmor {
    // field
    private int level;
    private final int MAX_LEVEL;
    private final int[] DEF;

    // constructor
    public Suit() {
        super("Suit", 10);
        setLevel(0);
        this.MAX_LEVEL = 3;
        this.DEF = new int[]{1, 2, 3, 5};
    }

    // method
    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        if (level > MAX_LEVEL || level < 0) level = 0;
        this.level = level;
    }

    public int getMaxLevel() {
        return this.MAX_LEVEL;
    }

    public int getDef() {
        return DEF[level];
    }

    public String toString() {
        return getName() + " (Def: " + getDef() + ", Level: " + getLevel() + ")";
    }
}

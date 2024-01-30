package item.consumption;

import item.base.BaseConsumption;
import item.usage.AttBuffable;
import item.usage.Upgradable;

public class StrengthPotion extends BaseConsumption implements AttBuffable , Upgradable {
    // field
    private int level;
    private final int MAX_LEVEL;
    private final int[] ATT_BUFF;
    private final int BUFF_TURN;

    // constructor
    public StrengthPotion() {
        super("StrengthPotion");
        setLevel(0);
        this.MAX_LEVEL = 3;
        this.BUFF_TURN = 3;
        ATT_BUFF = new int[]{3,5,7,10};
    }

    // method
    public int getAttBuff() {
        return this.ATT_BUFF[level];
    }

    public int getBuffTurn() {
        return this.BUFF_TURN;
    }

    public void setLevel(int level) {
        if (level > this.MAX_LEVEL || level < 0) level = 0;
        this.level = level;
    }

    public String toString() {
        return getName() + " (+" + getAttBuff() + " Att for next " + getBuffTurn() + " turns, Level: " + getLevel() + ")";
    }

    public int getLevel() {
        return this.level;
    }

    public int getMaxLevel() {
        return this.MAX_LEVEL;
    }
}

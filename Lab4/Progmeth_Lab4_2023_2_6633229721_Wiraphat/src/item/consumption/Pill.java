package item.consumption;

import item.base.BaseConsumption;
import item.usage.Healable;

public class Pill extends BaseConsumption implements Healable {
    // field
    private final int RECOVER_PT;

    // constructor
    public Pill() {
        super("Pill");
        this.RECOVER_PT = 2;
    }

    // method
    public String toString() {
        return getName() + " (+" + this.RECOVER_PT + " HP)";
    }

    public int getRecoverPoint() {
        return this.RECOVER_PT;
    }
}

package item.weapon;

import item.base.BaseWeapon;

public class Stick extends BaseWeapon {
    // field
    private final int ATT;

    // constructor
    public Stick() {
        super("Stick", 3, 0);
        this.ATT = 1;
    }

    // method
    public int getAtt() {
        return this.ATT;
    }
}

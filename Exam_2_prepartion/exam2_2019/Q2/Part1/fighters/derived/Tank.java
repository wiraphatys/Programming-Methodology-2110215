package fighters.derived;

import fighters.base.Guardable;
import fighters.base.Unit;

public class Tank extends Unit implements Guardable {
    // field
    private int defense;
    // constructor
    public Tank(int maxHealth, int speed, int defense, int location) {
        super("Tank", "t", maxHealth, speed, location, true);
        setDefense(defense);
    }

    // method
    public void guard() {
        onGuard = true;
    }

    public boolean move(int spaces) {
        onGuard  = false;
        return super.move(spaces);
    }
}

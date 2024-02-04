package fighters.derived;

import fighters.base.Attackable;
import fighters.base.Unit;
import logic.BattleUtils;

public class Wizard extends Unit implements Attackable {
    // constructor
    public Wizard(int maxHealth, int speed, int power, int location) {
        super("Wizard", "w", maxHealth, speed, location, true);
        setPower(power);
        setRange(2);
    }

    // method
    public int attack(Unit e) {
        if (this.sameTeam(e) || !BattleUtils.validRange(getRange(), this.getLocation(), e.getLocation())) {
            return -1;
        } else {
            return this.getPower();
        }
    }
}

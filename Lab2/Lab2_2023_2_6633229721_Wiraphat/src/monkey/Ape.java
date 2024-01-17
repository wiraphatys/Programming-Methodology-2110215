package monkey;

import logic.game.GameSystem;

import java.util.ArrayList;

public class Ape extends BaseMonkey {
    // constructor
    public Ape(int maxHP, int atk, int def) {
        super(maxHP, atk, def);
    }

    //method
    public void attackAOE() {
        ArrayList<BaseMonkey> monkeyContainer = GameSystem.getInstance().getMonkeyContainer();
        for (BaseMonkey m : monkeyContainer) {
            super.attack(m);
        }
    }
}

package monkey;

import static logic.game.GameSystem.getInstance;

public class MommyMonkey extends BaseMonkey {
    // constructor
    public MommyMonkey(int hp, int atk, int def) {
        super(hp, atk, def);
    }

    // method
    @Override
    public void attack(BaseMonkey m) {
    }

    @Override
    public String getType(){
        return "MommyMonkey";
    }

    public void birth() {
        // Initialize a new BaseMonkey using the default constructor
        BaseMonkey babyMonkey = new BaseMonkey();
        getInstance().getMonkeyContainer().add(babyMonkey);
    }
}


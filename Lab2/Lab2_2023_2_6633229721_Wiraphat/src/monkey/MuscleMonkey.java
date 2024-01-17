package monkey;

public class MuscleMonkey extends BaseMonkey {
    // attribute
    final int POWER_UP = 4;

    // constructor
    public MuscleMonkey(int maxHP, int atk, int def) {
        super(maxHP, atk, def);
    }

    // method
    @Override
    public String getType() {
        return "MuscleMonkey";
    }

    @Override
    public void attack(BaseMonkey m) {
        for (int i = 0; i < 2; ++i) {
            super.attack(m);
        }
    }

    public void buff() {
        this.setAtk(this.getAtk() + this.POWER_UP);
        this.setDef(this.getDef() + this.POWER_UP);
    }

    public int getPOWER_UP() {
        return this.POWER_UP;
    }
}

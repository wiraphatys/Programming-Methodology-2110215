package monkey;

public class UgabugagaMonkey extends BaseMonkey {
    // attribute
    final int DEBUFF = 1;
    final int HEAL = 10;

    // constructor
    public UgabugagaMonkey(int maxHP, int atk, int def) {
        super(maxHP, atk, def);
    }

    // method
    @Override
    public void attack(BaseMonkey m) {
        super.attack(m);
        m.setAtk(m.getAtk() - DEBUFF);
        m.setDef(m.getDef() - DEBUFF);
    }

    @Override
    public String getType() {
        return "UgabugagaMonkey";
    }

    public void heal(BaseMonkey m) {
        m.setHp(m.getHp() + HEAL);
    }

    public int getDEBUFF() {
        return this.DEBUFF;
    }

    public int getHEAL() {
        return this.HEAL;
    }
}

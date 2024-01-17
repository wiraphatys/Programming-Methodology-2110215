package monkey;

public class BaseMonkey {
    // attribute
    private int maxHP;
    private int hp;
    private int atk;
    private int def;

    // constructor
    // Default constructor
    public BaseMonkey() {
        this.maxHP = 30;
        this.hp = maxHP;
        this.atk = 20;
        this.def = 5;
    }

    // Parameterized constructor
    public BaseMonkey(int maxHP, int atk, int def) {
        this.maxHP = Math.max(maxHP, 0);
        this.hp = this.maxHP;
        this.atk = Math.max(atk, 0);
        this.def = Math.max(def, 0);
    }

    // method
    public void attack(BaseMonkey m) {
        int damage = this.atk - m.def;
        m.setHp(m.getHp() - damage);
    }

    public String getType() {
        return "BaseMonkey";
    }

    @Override
    public String toString() {
        return getType() + "hp=" + this.hp + " atk=" + this.atk + " def=" + this.def;
    }

    public int getMaxHp() {
        return maxHP;
    }

    public void setMaxHp(int maxHP) {
        this.maxHP = Math.max(0, maxHP);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        if (hp > maxHP) {
            hp = maxHP;
        }
        if (hp < 0) {
            hp = 0;
        }
        this.hp = hp;
    }


    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = Math.max(atk, 0);
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = Math.max(def, 0);
    }
}

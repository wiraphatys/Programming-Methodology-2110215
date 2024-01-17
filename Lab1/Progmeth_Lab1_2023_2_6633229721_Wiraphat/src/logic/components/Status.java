package logic.components;

import exception.BadStatusException;

import java.util.Objects;

public class Status {
//    field
    private int hp;
    private int durability;
    private int attack;
    private int magic;

//    constructor
    public Status(int hp, int durability, int attack, int magic) throws BadStatusException {
        setHp(hp);
        setDurability(durability);
        setAttack(attack);
        setMagic(magic);
    }

//    method
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return hp == status.hp &&
                durability == status.durability &&
                attack == status.attack &&
                magic == status.magic;
    }

    // method
    public void addStatus(Status another) throws BadStatusException {
        int newHp = this.hp + another.hp;
        int newDurability = this.durability + another.durability;
        int newAttack = this.attack + another.attack;
        int newMagic = this.magic + another.magic;

        // check if any result value would be negative
        if (newHp < 0 || newDurability < 0 || newAttack < 0 || newMagic < 0) {
            throw new BadStatusException();
        }

        // update the fields
        this.hp = newHp;
        this.durability = newDurability;
        this.attack = newAttack;
        this.magic = newMagic;
    }
    public void setHp(int hp) throws BadStatusException {
        if (hp < 0) {
            throw new BadStatusException();
        }
        this.hp = hp;
    }

    public int getHp() {
        return this.hp;
    }

    public void setDurability(int durability) throws BadStatusException {
        if (durability < 0) {
            throw new BadStatusException();
        }
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setAttack(int attack) throws BadStatusException {
        if (attack < 0) {
            throw new BadStatusException();
        }
        this.attack = attack;
    }

    public int getAttack() {
        return this.attack;
    }

    public void setMagic(int magic) throws BadStatusException {
        if (magic < 0) {
            throw new BadStatusException();
        }
        this.magic = magic;
    }

    public int getMagic() {
        return this.magic;
    }
}

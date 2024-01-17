package logic.components;

import exception.BadStatusException;

public class Monster {
    // fields
    private String name;
    private Status status;
    private Food food;
    private Potion potion;

    // constructor
    public Monster(String name, Status status) {
        if (status.getHp() < 1) {
            try {
                status.setHp(1);
            } catch (BadStatusException e) {
                throw new RuntimeException(e);
            }
        }
        this.name = name;
        this.status = status;
        this.food = null;
        this.potion = null;
    }

    public void attack(Player player) {
        int damage = Math.max(status.getAttack() - player.getStatus().getDurability(), 0);

        int hp = player.getStatus().getHp();
        try {
            player.getStatus().setHp((hp < damage) ? 0 : hp - damage);
        } catch (BadStatusException e) {
            throw new RuntimeException(e);
        }
    }

    public void magicAttack(Player player) {
        int damage = this.status.getMagic();

        int hp = player.getStatus().getHp();
        try {
            player.getStatus().setHp(hp < damage ? 0 : hp - damage);
        } catch (BadStatusException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Food getFood() {
        return this.food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Potion getPotion() {
        return this.potion;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }
}

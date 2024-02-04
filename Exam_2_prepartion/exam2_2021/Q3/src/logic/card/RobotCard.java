package logic.card;

import logic.player.Player;

public class RobotCard extends BaseCard {
    // field
    private int energyCost;

    // constructor
    public RobotCard(String name, int power, int health, int energyCost) {
        super(name, power, health);
        setEnergyCost(energyCost);
    }

    // method
    public void play(Player player) {
        player.setEnergy(player.getEnergy() - energyCost);
    }

    public boolean canPlay(Player player) {
        return player.getEnergy() >= energyCost;
    }

    public void setEnergyCost(int energyCost) {
        this.energyCost = Math.max(0, energyCost);
    }

    public int getEnergyCost() {
        return energyCost;
    }
}

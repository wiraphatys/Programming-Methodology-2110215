package logic.card;

import logic.player.Player;

public class MageCard extends BaseCard {
    // field
    private Element mageType;

    // constructor
    public MageCard(String name, int power, int health, Element mageType) {
        super(name, power, health);
        setMageType(mageType);
    }

    // method
    public void play(Player player) {
        int amount = 0;
        for (BaseCard card : player.getField()) {
            if (card instanceof OrbCard o && o.getOrbType().equals(this.getMageType())) {
                ++amount;
            }
        }
        this.setPower(this.getPower() + amount);
    }

    public boolean canPlay(Player player) {
        for (BaseCard card : player.getField()) {
            if (card instanceof OrbCard o && o.getOrbType().equals(this.getMageType())) {
                return true;
            }
        }
        return false;
    }

    public void setMageType(Element mageType) {
        this.mageType = mageType;
    }

    public Element getMageType() {
        return mageType;
    }
}

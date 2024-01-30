package table;

import item.base.BaseItem;
import item.usage.Upgradable;

public class Enchanter extends BaseTable {

    public Enchanter() {
        super("Enchanter");
    }

    @Override
    public String interact(BaseItem baseItem) {
        // FILL CODE
        String result = "";
        if (baseItem instanceof Upgradable item) {
            if (item.getLevel() < item.getMaxLevel()) {
                item.setLevel(item.getLevel() + 1);
                result = "Upgrade successfully";
            } else if (item.getLevel() == item.getMaxLevel()) {
                result = "Already max level";
            }
        } else {
            result = "This item cannot be upgraded";
        }
        return result;
    }

}

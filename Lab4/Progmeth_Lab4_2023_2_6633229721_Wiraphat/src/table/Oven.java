package table;

import item.base.BaseItem;
import item.usage.CookState;
import item.usage.Cookable;

public class Oven extends BaseTable {

    public Oven() {
        super("Oven");
    }

    @Override
    public String interact(BaseItem baseItem) {
        // FILL CODE
        String result = "";
        if (baseItem instanceof Cookable item) {
            if (item.getCookState() == CookState.RAW) {
                item.setCookState(CookState.COOKED);
                result = "Cooking succeed";
            } else if (item.getCookState() == CookState.COOKED) {
                item.setCookState(CookState.BURNT);
                result = "Your food has been burnt";
            } else if (item.getCookState() == CookState.BURNT) {
                result =  "Your food is already burnt, cannot be cooked anymore";
            }
        } else {
            result = "This item cannot be cooked";
        }
        return result;
    }
}

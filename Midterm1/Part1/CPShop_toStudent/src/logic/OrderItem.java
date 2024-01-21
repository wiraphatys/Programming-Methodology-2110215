package logic;

public class OrderItem {
    // field
    private Item item;
    private int itemAmount;

    // constructor
    public OrderItem(Item item, int itemAmount) {
        setItem(item);
        setItemAmount(itemAmount);
    }

    // method
    public void increaseItemAmount(int amount) {
        if (amount > 0) this.itemAmount += amount;
    }

    public int calculateTotalPrice() {
        return item.getPricePerPiece() * itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        if (itemAmount < 0) itemAmount = 0;
        this.itemAmount = itemAmount;
    }

    public int getItemAmount() {
        return this.itemAmount;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }
}

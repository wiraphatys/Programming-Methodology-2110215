package products;

import discount.PercentDiscountable;
import discount.Sellable;
import logic.ShopUtil;

public class PercentDiscountProduct extends BaseProduct implements Sellable , PercentDiscountable {
    // field
    private double percent;

    // constructor
    public PercentDiscountProduct(String name, int price, double percent) {
        super(name, price);
        setPercent(percent);
    }

    // method
    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        if (percent > 100) percent = 100;
        if (percent < 0) percent = 0;
        this.percent = percent;
    }

    public int calcDiscountPerPiece() {
        return ShopUtil.calculateDiscountUsingPercent(price, percent);
    }

    public int calculateDiscount(int quantity) {
        return quantity * calcDiscountPerPiece();
    }

    public String toString() {
        return this.getProductName() + " (Price: " + this.getPrice() +", "+ this.getPercent() + "% Off)";
    }
}

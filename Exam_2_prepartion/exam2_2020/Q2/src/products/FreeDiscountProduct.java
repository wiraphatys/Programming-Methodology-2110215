package products;

import discount.FreeDiscountable;
import discount.Sellable;
import logic.ShopUtil;

public class FreeDiscountProduct extends BaseProduct implements Sellable , FreeDiscountable {
    // field
    private int promoQuantity;
    private int freeQuantity;

    // constructor
    public FreeDiscountProduct(String name, int price, int promoQ, int freeQ) {
        super(name, price);
        setFreeQuantity(freeQ);
        setPromoQuantity(promoQ);
    }


    // method
    public int calcFreeDiscountPieces(int totalQuantityBought) {
        return ShopUtil.calculateFreeDiscountPieces(freeQuantity, promoQuantity, totalQuantityBought);
    }

    public int calculateDiscount(int quantity) {
        return calcFreeDiscountPieces(quantity) * getPrice();
    }

    public String toString() {
        return this.getProductName() + " (Price: " + this.getPrice() + ", Buy " + this.getPromoQuantity() + " Get " + this.getFreeQuantity() + " Free)";
    }

    public int getPromoQuantity() {
        return promoQuantity;
    }

    public void setPromoQuantity(int promoQuantity) {
        this.promoQuantity = Math.max(1, promoQuantity);
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }

    public void setFreeQuantity(int freeQuantity) {
        this.freeQuantity = Math.max(1, freeQuantity);
    }
}

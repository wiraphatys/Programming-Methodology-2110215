package logic;

public class Item {
    // field
    private String name;
    private int pricePerPiece;

    // constructor
    public Item(String name, int pricePerPiece) {
        setName(name);
        setPricePerPiece(pricePerPiece);
    }

    // method
    public void setPricePerPiece(int pricePerPiece) {
        this.pricePerPiece = Math.max(pricePerPiece, 1);
    }

    public int getPricePerPiece() {
        return this.pricePerPiece;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

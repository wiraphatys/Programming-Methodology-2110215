import java.util.Scanner;

public class FoodOrder {

	// Fields: description, price, chicken, vegetable, extraChicken, extraRice
	// START CODE HERE
	private final String description;
	private final int price;
	private boolean hasChicken;
	private boolean hasVegetable;
	private boolean hasExtraChicken;
	private boolean hasExtraRice;
	// END CODE HERE

	// Constructor
	// START CODE HERE
	public FoodOrder() {
		this.description = "Hainanese Chicken Rice";
		this.hasChicken = true;
		this.hasVegetable = true;
		this.hasExtraChicken = false;
		this.hasExtraRice = false;
		this.price = calculatePrice();
	}
	// END CODE HERE

	// Methods
	// START CODE HERE
	public String getDescription() {
		return this.description;
	}

	public int getPrice() {
		return this.price;
	}

	private int calculatePrice() {
		int price = 40;
		if (!hasChicken) price -= 10;
		if (hasExtraChicken) price += 10;
		if (hasExtraRice) price += 5;
		return price;
	}

	public void setHasChicken(boolean state) {
		hasChicken = state;
	}

	public void setHasVegetable(boolean state) {
		hasVegetable = state;
	}

	public void setHasExtraChicken(boolean state) {
		hasExtraChicken = state;
	}

	public void setHasExtraRice(boolean state) {
		hasExtraRice = state;
	}
	// END CODE HERE

	@Override
	public String toString() {
		// START CODE HERE
		String result = "That would be " + this.getPrice() + " baht. Thanks!\n"
				+ this.getDescription() + "\n"
				+ "Chicken:" + hasChicken + "\n"
				+ "Vegetable:" + hasVegetable + "\n"
				+ "Extra Chicken:" + hasExtraChicken + "\n"
				+ "Extra Rice:" + hasExtraRice;
		return result;
		// END CODE HERE
	}

	@Override
	public boolean equals(Object other) {
		// START CODE HERE
		return this.getPrice() == ((FoodOrder) other).getPrice();
		// END CODE HERE
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		FoodOrder foodOrder = new FoodOrder();
		System.out.println("Hi, Welcome to Kao-Mun-Gai food stall!");
		System.out.println("We only sell " + foodOrder.getDescription());
		System.out.println("Would you like your meal with chicken? (Yes/No)");
		String customerInput = keyboard.next();
		if (customerInput.equals("No")) {
			foodOrder.setHasChicken(false);
			System.out.println("Okay...");
		} else if (customerInput.equals("Yes")) {
			foodOrder.setHasChicken(true);
		}
		System.out.println("Would you like your meal with vegetable? (Yes/No)");
		customerInput = keyboard.next();
		if (customerInput.equals("No")) {
			foodOrder.setHasVegetable(false);
		} else if (customerInput.equals("Yes")) {
			foodOrder.setHasVegetable(true);
		}
		System.out.println("Extra chicken? (Yes/No)");
		customerInput = keyboard.next();
		if (customerInput.equals("Yes")) {
			foodOrder.setHasExtraChicken(true);
			System.out.println("Good Choice!");
		} else if (customerInput.equals("No")) {
			foodOrder.setHasExtraChicken(false);
		}
		System.out.println("Extra Rice? (Yes/No)");
		customerInput = keyboard.next();
		if (customerInput.equals("Yes")) {
			foodOrder.setHasExtraRice(true);
		} else if (customerInput.equals("No")) {
			foodOrder.setHasExtraRice(false);
		}

		System.out.println(foodOrder);

		// Uncomment the following lines to test equals method
		 FoodOrder testOrder = new FoodOrder();
		 testOrder.setHasChicken(false);
		 testOrder.setHasExtraChicken(false);
		 testOrder.setHasExtraRice(true);
		 FoodOrder testOrder2 = new FoodOrder();
		 testOrder2.setHasChicken(false);
		 testOrder2.setHasExtraChicken(false);
		 testOrder2.setHasExtraRice(true);
		 System.out.println("Equal:" + testOrder.equals(testOrder2));
	}

}

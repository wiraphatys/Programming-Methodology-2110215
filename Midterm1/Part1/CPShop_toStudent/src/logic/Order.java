package logic;

import java.util.ArrayList;

public class Order {
	private ArrayList<OrderItem> orderItemList;
	private static int totalOrderCount = 0;
	private int orderNumber;
	
	public Order() {
		// TODO
		this.orderItemList = new ArrayList<>();
		this.orderNumber = totalOrderCount;
		++totalOrderCount;
	}

	public OrderItem addItem(Item item, int amount) {
		// TODO
		OrderItem e = new OrderItem(item, amount);

		for (OrderItem i : orderItemList) {
			if (i.getItem().equals(e.getItem())) {
				i.setItemAmount(i.getItemAmount() + e.getItemAmount());
				return e;
			}
		}
		orderItemList.add(e);
		return e;
	}

	public int calculateOrderTotalPrice() {
		// TODO
		// Calculate total price of the order by summing total price of each orderItem in orderItemList
		int totalPrice = 0;

		for (OrderItem e : orderItemList) {
			totalPrice += e.getItemAmount() * e.getItem().getPricePerPiece();
		}

		return totalPrice;
		
	}

	public static int getTotalOrderCount() {
		return totalOrderCount;
	}
	
	public static void resetTotalOrderCount() {
		totalOrderCount = 0;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ArrayList<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	
	
}

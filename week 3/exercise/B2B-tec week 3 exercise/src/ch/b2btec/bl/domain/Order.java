package ch.b2btec.bl.domain;

public class Order {
	private final ShoppingCart cart = new ShoppingCart();
	private final int orderNumber;
	private OrderState state = OrderState.New;

	public Order(int orderNumber) {
		checkOrderNumber(orderNumber);
		this.orderNumber = orderNumber;
	}

	public OrderState getState() {
		return state;
	}

	public void updateState(OrderState state) {
		checkOrderState(state);
		this.state = state;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	private static void checkOrderState(OrderState orderState) {
		if (orderState == null) {
			throw new IllegalArgumentException("Order state must not be null");
		}
	}

	private void checkOrderNumber(int orderNumber) {
		if (orderNumber <= 0) {
			throw new IllegalArgumentException("Order number must not be zero or negative");
		}
	}

	public String toString() {
		return "#" + orderNumber + " " + state;
	}

}

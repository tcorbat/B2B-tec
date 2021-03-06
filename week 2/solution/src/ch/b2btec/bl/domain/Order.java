package ch.b2btec.bl.domain;

public class Order {
	private final ShoppingCart cart = new ShoppingCart();
	private OrderState state = OrderState.New;

	public OrderState getState() {
		return state;
	}

	public void updateState(OrderState state) {
		checkOrderState(state);
		this.state = state;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	private static void checkOrderState(OrderState orderState) {
		if (orderState == null) {
			throw new IllegalArgumentException("Order state must not be null");
		}
	}
}

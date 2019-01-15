package ch.b2btec.bl.domain;

public class Order {
	private final ShoppingCart cart = new ShoppingCart();
	private final Customer customer;
	private OrderState state = OrderState.New;

	public Order(Customer customer) {
		checkCustomer(customer);
		this.customer = customer;
	}

	public OrderState getState() {
		return state;
	}

	public void updateState(OrderState state) {
		checkOrderState(state);
		this.state = state;
	}

	public Customer getCustomer() {
		return customer;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	private static void checkCustomer(Customer customer) {
		if (customer == null) {
			throw new IllegalArgumentException("Customer must not be null");
		}
	}

	private static void checkOrderState(OrderState orderState) {
		if (orderState == null) {
			throw new IllegalArgumentException("Order state must not be null");
		}
	}
}

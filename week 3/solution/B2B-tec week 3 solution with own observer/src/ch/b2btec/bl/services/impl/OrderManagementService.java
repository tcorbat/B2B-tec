package ch.b2btec.bl.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Order;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.domain.ShoppingCart;
import ch.b2btec.bl.services.OrderManagement;

public class OrderManagementService implements OrderManagement {

	private final HashMap<Customer, ArrayList<Order>> orders = new HashMap<>();
	private int nextOrderNumber = 1;

	private void createDummyData(Customer customer) {
			var customersOrders = new ArrayList<Order>();
			Order order = new Order(getNextOrderNumber());
			Product nail = new Product(1, "Nail", 1, "Hammered", "2mm");
			ShoppingCart cart = order.getCart();
			IntStream.range(1, 5).forEach(i -> cart.addProduct(nail));
			Product screw = new Product(2, "Screw", 2, "Twisted", "4mm");
			IntStream.range(1, 5).forEach(i -> cart.addProduct(screw));
			customersOrders.add(order);
			orders.put(customer, customersOrders);
	}
	
	private int getNextOrderNumber() {
		return nextOrderNumber++;
	}

	@Override
	public List<Order> getOrders(Customer customer) {
		if (!orders.containsKey(customer)) {
			createDummyData(customer);
		}
		var customersOrders = orders.get(customer);
		if (customersOrders.isEmpty()) {
			customersOrders.add(new Order(getNextOrderNumber()));
		}
		return Collections.unmodifiableList(customersOrders);
	}

	private void storeOrder(Customer customer, Order order) {
		if (!orders.containsKey(customer)) {
			createDummyData(customer);
		}
		var customersOrders = orders.get(customer);
		customersOrders.add(order);
	}

	@Override
	public Order createOrder(Customer customer) {
		var order = new Order(getNextOrderNumber());
		storeOrder(customer, order);
		return order;
	}

}

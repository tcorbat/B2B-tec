package ch.b2btec.bl.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

import ch.b2btec.bl.Price;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Order;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.domain.ShoppingCart;
import ch.b2btec.bl.services.OrderManagement;

public class OrderManagementService implements OrderManagement {

	private final HashMap<Customer, ArrayList<Order>> orders = new HashMap<>();
	private static int nextOrderNumber = 1;

	private void createDummyData(Customer customer) {
		if (!orders.containsKey(customer)) {
			var customersOrders = new ArrayList<Order>();
			Order order = new Order(customer, nextOrderNumber++);
			Product nail = new Product(1, "Nail", new Price(1), "Hammered", "2mm");
			ShoppingCart cart = order.getCart();
			IntStream.range(1, 5).forEach(i -> cart.addProduct(nail));
			Product screw = new Product(2, "Screw", new Price(2), "Twisted", "4mm");
			IntStream.range(1, 5).forEach(i -> cart.addProduct(screw));
			customersOrders.add(order);
			orders.put(customer, customersOrders);
		}
	}
	
	@Override
	public List<Order> getOrders(Customer customer) {
		createDummyData(customer);
		if (!orders.containsKey(customer)) {
			orders.put(customer, new ArrayList<>());
		}
		var customersOrders = orders.get(customer);
		if (customersOrders.isEmpty()) {
			customersOrders.add(new Order(customer, nextOrderNumber++));
		}
		return Collections.unmodifiableList(customersOrders);
	}

}

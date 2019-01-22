package ch.b2btec.bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Order;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.domain.ShoppingCart;

public class OrderManagementService implements OrderManagement {

	@Override
	public List<Order> getOrders(Customer customer) {
		var orders = new ArrayList<Order>();
		Order order = new Order(customer, 1);
		Product nail = new Product(1, "Nail", 1, "Hammered", "2mm");
		ShoppingCart cart = order.getCart();
		IntStream.range(1, 5).forEach(i -> cart.addProduct(nail));
		Product screw = new Product(2, "Screw", 2, "Twisted", "4mm");
		IntStream.range(1, 5).forEach(i -> cart.addProduct(screw));
		orders.add(order);
		return Collections.unmodifiableList(orders);
	}

}

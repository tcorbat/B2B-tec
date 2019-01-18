package ch.b2btec.bl;

import java.util.List;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Order;

public interface OrderManagement {
	List<Order> getOrders(Customer customer);
}

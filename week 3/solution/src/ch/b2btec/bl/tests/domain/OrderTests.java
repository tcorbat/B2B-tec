package ch.b2btec.bl.tests.domain;

import static ch.b2btec.bl.tests.domain.DefaultTestValues.DEFAULT_CUSTOMER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Order;
import ch.b2btec.bl.domain.OrderState;

class OrderTests {

	@Test
	void testCustomerIsSet() {
		var order = new Order(DEFAULT_CUSTOMER);
		assertEquals(DEFAULT_CUSTOMER, order.getCustomer());
	}

	@Test
	void testCustomerCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> new Order(null));
	}

	@Test
	void testShoppingCartIsNotNull() {
		var order = new Order(DefaultTestValues.DEFAULT_CUSTOMER);
		assertNotNull(order.getCart());
	}

	@Test
	void testInitialOrderStateIsNew() {
		var order = new Order(DefaultTestValues.DEFAULT_CUSTOMER);
		assertEquals(OrderState.New, order.getState());
	}

	@Test
	void testOrderStateIsUpdated() {
		var order = new Order(DefaultTestValues.DEFAULT_CUSTOMER);
		order.updateState(OrderState.Paid);
		assertEquals(OrderState.Paid, order.getState());
	}

	@Test
	void testOrderStateCannotBeNull() {
		var order = new Order(DefaultTestValues.DEFAULT_CUSTOMER);
		assertThrows(IllegalArgumentException.class, () -> order.updateState(null));
	}
}
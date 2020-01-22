package ch.b2btec.bl.domain.tests;

import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_ORDER_NUMBER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Order;
import ch.b2btec.bl.domain.OrderState;

class OrderTests {
	@Test
	void testShoppingCartIsNotNull() {
		var order = new Order(DEFAULT_ORDER_NUMBER);
		assertNotNull(order.getCart());
	}

	@Test
	void testInitialOrderStateIsNew() {
		var order = new Order(DEFAULT_ORDER_NUMBER);
		assertEquals(OrderState.New, order.getState());
	}

	@Test
	void testOrderStateIsUpdated() {
		var order = new Order(DEFAULT_ORDER_NUMBER);
		order.updateState(OrderState.Paid);
		assertEquals(OrderState.Paid, order.getState());
	}

	@Test
	void testOrderStateCannotBeNull() {
		var order = new Order(DEFAULT_ORDER_NUMBER);
		assertThrows(IllegalArgumentException.class, () -> order.updateState(null));
	}

	@Test
	void testOrderNumberIsSet() {
		var order = new Order(DEFAULT_ORDER_NUMBER);
		assertEquals(DEFAULT_ORDER_NUMBER, order.getOrderNumber());
	}

	@Test
	void testOrderNumberIsNotZero() {
		assertThrows(IllegalArgumentException.class, () -> new Order(0));
	}

	@Test
	void testOrderNumberIsNotNegative() {
		assertThrows(IllegalArgumentException.class, () -> new Order(-1));
	}
}

package ch.b2btec.bl.domain.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Order;
import ch.b2btec.bl.domain.OrderState;

class OrderTests {

	@Test
	void testInitialOrderStateIsNew() {
		var order = new Order();
		assertEquals(OrderState.New, order.getState());
	}

	@Test
	void testOrderStateIsUpdated() {
		var order = new Order();
		order.updateState(OrderState.Paid);
		assertEquals(OrderState.Paid, order.getState());
	}

	@Test
	void testOrderStateCannotBeNull() {
		var order = new Order();
		assertThrows(IllegalArgumentException.class, () -> order.updateState(null));
	}
}

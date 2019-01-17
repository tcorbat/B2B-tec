package ch.b2btec.bl.tests.domain;

import static ch.b2btec.bl.tests.domain.DefaultTestValues.DEFAULT_PRODUCT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.OrderPosition;
import ch.b2btec.bl.domain.QuantityMustBePositiveException;

class OrderPositionTests {

	@Test
	void testInitialProductIsUsed() {
		var position = new OrderPosition(DEFAULT_PRODUCT, 1);
		assertEquals(DEFAULT_PRODUCT, position.getProduct());
	}

	@Test
	void testProductCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> new OrderPosition(null, 0));
	}

	@Test
	void testInitialQuantityIsUsed() {
		final int quantity = 10;
		var position = new OrderPosition(DEFAULT_PRODUCT, quantity);
		assertEquals(quantity, position.getQuantity());
	}

	@Test
	void testQuantityCannotBeNegative() {
		assertThrows(QuantityMustBePositiveException.class, () -> new OrderPosition(DEFAULT_PRODUCT, -1));
	}

	@Test
	void testQuantityCannotBecomNegativeByDecrement() {
		var orderPosition = new OrderPosition(DEFAULT_PRODUCT, 0);
		assertThrows(QuantityMustBePositiveException.class, () -> orderPosition.decrementQuantity());
		assertEquals(0, orderPosition.getQuantity());
	}

	@Test
	void testQuantityCannotBecomNegativeBySetQuantity() {
		final int initialQuantity = 15;
		var orderPosition = new OrderPosition(DEFAULT_PRODUCT, initialQuantity);
		assertThrows(QuantityMustBePositiveException.class, () -> orderPosition.setQuantity(-1));
		assertEquals(initialQuantity, orderPosition.getQuantity());
	}

	@Test
	void testSetQuantitySetsQuantity() {
		final int expectedQuantity = 42;
		var orderPosition = new OrderPosition(DEFAULT_PRODUCT, 0);

		orderPosition.setQuantity(expectedQuantity);

		assertEquals(expectedQuantity, orderPosition.getQuantity());
	}

	@Test
	void testIncresseQuantitiyIncrementsQuantity() {
		var orderPosition = new OrderPosition(DEFAULT_PRODUCT, 0);

		orderPosition.incrementQuantity();

		assertEquals(1, orderPosition.getQuantity());
	}
}

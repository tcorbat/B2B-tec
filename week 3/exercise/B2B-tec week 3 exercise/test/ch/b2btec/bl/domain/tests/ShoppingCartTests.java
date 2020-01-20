package ch.b2btec.bl.domain.tests;

import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_PRODUCT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.OrderPosition;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.domain.ShoppingCart;

class ShoppingCartTests {

	@Test
	void testInitialShoppingCartIsEmpty() {
		var cart = new ShoppingCart();
		var positions = cart.getPositions();
		assertTrue(positions.isEmpty());
	}

	@Test
	void testCannotAddNullAsProduct() {
		var cart = new ShoppingCart();
		assertThrows(IllegalArgumentException.class, () -> cart.addProduct(null));
	}

	@Test
	void testProductIsAddedToAPosition() {
		var cart = new ShoppingCart();
		cart.addProduct(DEFAULT_PRODUCT);

		var positions = cart.getPositions();
		assertEquals(1, positions.size());
		OrderPosition firstPosition = positions.get(0);
		assertEquals(DEFAULT_PRODUCT, firstPosition.getProduct());
		assertEquals(1, firstPosition.getQuantity());
	}

	@Test
	void testAddingTheSameProductMultipleTimes() {
		var cart = new ShoppingCart();
		final int iterations = 5;
		for (int i = 0; i < 5; i++) {
			cart.addProduct(DEFAULT_PRODUCT);
		}

		var positions = cart.getPositions();
		assertEquals(1, positions.size());
		OrderPosition firstPosition = positions.get(0);
		assertEquals(DEFAULT_PRODUCT, firstPosition.getProduct());
		assertEquals(iterations, firstPosition.getQuantity());
	}

	@Test
	void testAddingMultipleDifferentProducts() {
		var cart = new ShoppingCart();
		cart.addProduct(DEFAULT_PRODUCT);
		var otherProduct = new Product(999, "Mug", 5, "Holds coffee", "2dl");
		cart.addProduct(otherProduct);

		var positions = cart.getPositions();
		assertEquals(2, positions.size());

		OrderPosition firstPosition = positions.get(0);
		assertEquals(DEFAULT_PRODUCT, firstPosition.getProduct());
		assertEquals(1, firstPosition.getQuantity());
		OrderPosition secondPosition = positions.get(1);
		assertEquals(otherProduct, secondPosition.getProduct());
		assertEquals(1, secondPosition.getQuantity());
	}

}

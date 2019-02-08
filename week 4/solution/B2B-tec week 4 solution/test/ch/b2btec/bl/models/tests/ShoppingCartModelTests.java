package ch.b2btec.bl.models.tests;

import static ch.b2btec.bl.models.tests.TestProductFactory.createTestItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.PropertyChangeEvent;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.Price;
import ch.b2btec.bl.domain.ShoppingCart;
import ch.b2btec.ui.models.ShoppingCartModel;

class ShoppingCartModelTests {
	@Test
	void testShoppingCartModelRegistersAsObserverOfShoppingCart() {
		var cart = new ShoppingCartSpy();
		new ShoppingCartModel(cart);
		assertEquals(1, cart.getRegisteredListeners().length);
	}

	@Test
	void testGetTotalPriceForEmptyCart() {
		var cart = new ShoppingCart();
		var model = new ShoppingCartModel(cart);
		assertEquals(new Price(0), model.getTotalPrice());
	}

	@Test
	void testGetTotalPriceIsUpdatedAfterChangeToCart() {
		//given
		int price = 15;
		var product = createTestItem(price);
		var cart = new ShoppingCart();
		var model = new ShoppingCartModel(cart);
		
		//when
		cart.addProduct(product);

		// then
		assertEquals(new Price(price), model.getTotalPrice());
	}

	@Test
	void testGetTotalPriceIsUpdatedAfterMultipleAdditionsToCart() {
		// given
		int priceForProduct1 = 11;
		var product1 = createTestItem(priceForProduct1);
		int priceForProduct2 = 7;
		var product2 = createTestItem(priceForProduct2);
		int priceForProduct3 = 5;
		var product3 = createTestItem(priceForProduct3);
		var cart = new ShoppingCart();
		var model = new ShoppingCartModel(cart);

		// when
		cart.addProduct(product1);
		cart.addProduct(product2);
		cart.addProduct(product2);
		cart.addProduct(product3);
		cart.addProduct(product3);
		cart.addProduct(product3);

		// then
		var expected = new Price(priceForProduct1 + 2 * priceForProduct2 + 3 * priceForProduct3);
		assertEquals(expected, model.getTotalPrice());
	}

	@Test
	void testGetTotalNumberOfItemsForEmptyCart() {
		var cart = new ShoppingCart();
		var model = new ShoppingCartModel(cart);
		assertEquals(0, model.getTotalNumberOfItems());
	}

	@Test
	void testGetTotalNumberOfItemsIsUpdatedAfterChangeToCart() {
		// given
		var product = createTestItem(15);
		var cart = new ShoppingCart();
		var model = new ShoppingCartModel(cart);

		// when
		cart.addProduct(product);

		// then
		assertEquals(1, model.getTotalNumberOfItems());
	}

	@Test
	void testGetNumberOfItemsIsUpdatedAfterMultipleAdditionsToCart() {
		// given
		var product1 = createTestItem(11);
		var product2 = createTestItem(7);
		var product3 = createTestItem(5);
		var cart = new ShoppingCart();
		var model = new ShoppingCartModel(cart);

		// when
		cart.addProduct(product1);
		cart.addProduct(product2);
		cart.addProduct(product2);
		cart.addProduct(product3);
		cart.addProduct(product3);
		cart.addProduct(product3);

		// then
		assertEquals(6, model.getTotalNumberOfItems());
	}

	@Test
	void testShoppingCartModelUpdatesObservers() {
		var product = createTestItem(11);
		var cart = new ShoppingCart();
		var model = new ShoppingCartModel(cart);
		var modelObserver = new ShoppingCartModelObserverMock(model,
				new PropertyChangeEvent(model, ShoppingCartModel.Property.TotalPrice.toString(), 0, new Price(11)),
				new PropertyChangeEvent(model, ShoppingCartModel.Property.TotalNumberOfItems.toString(), 0, 1));

		// when
		cart.addProduct(product);

		// then
		modelObserver.assertEvents();
	}

	@Test
	void testShoppingCartModelUpdatesObserversForEveryItem() {
		var product1 = createTestItem(11);
		var product2 = createTestItem(15);
		var cart = new ShoppingCart();
		var model = new ShoppingCartModel(cart);
		var modelObserver = new ShoppingCartModelObserverMock(model,
				new PropertyChangeEvent(model, ShoppingCartModel.Property.TotalPrice.toString(), 0, new Price(11)),
				new PropertyChangeEvent(model, ShoppingCartModel.Property.TotalNumberOfItems.toString(), 0, 1),
				new PropertyChangeEvent(model, ShoppingCartModel.Property.TotalPrice.toString(), 0, new Price(22)),
				new PropertyChangeEvent(model, ShoppingCartModel.Property.TotalNumberOfItems.toString(), 0, 2),
				new PropertyChangeEvent(model, ShoppingCartModel.Property.TotalPrice.toString(), 0, new Price(33)),
				new PropertyChangeEvent(model, ShoppingCartModel.Property.TotalNumberOfItems.toString(), 0, 3),
				new PropertyChangeEvent(model, ShoppingCartModel.Property.TotalPrice.toString(), 0, new Price(48)),
				new PropertyChangeEvent(model, ShoppingCartModel.Property.TotalNumberOfItems.toString(), 0, 4));

		// when
		cart.addProduct(product1);
		cart.addProduct(product1);
		cart.addProduct(product1);
		cart.addProduct(product2);

		// then
		modelObserver.assertEvents();
	}
}

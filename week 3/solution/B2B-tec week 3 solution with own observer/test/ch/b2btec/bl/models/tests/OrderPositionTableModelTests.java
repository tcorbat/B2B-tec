package ch.b2btec.bl.models.tests;

import static ch.b2btec.bl.models.tests.TestProductFactory.createTestItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.swing.event.TableModelEvent;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.ShoppingCart;
import ch.b2btec.ui.models.OrderPositionTableModel;

class OrderPositionTableModelTests {

	@Test
	void testGetRowCountIsInitiallyZero() {
		var cart = new ShoppingCart();
		var model = new OrderPositionTableModel(cart);
		assertEquals(0, model.getRowCount());
	}

	@Test
	void testGetRowCountCombinesTheSameProduct() {
		// given
		var cart = new ShoppingCart();
		var model = new OrderPositionTableModel(cart);
		var product = createTestItem(15);

		// when
		cart.addProduct(product);
		cart.addProduct(product);
		cart.addProduct(product);

		// then
		assertEquals(1, model.getRowCount());
	}

	@Test
	void testGetRowCountHasRowsForDifferentProducts() {
		// given
		var cart = new ShoppingCart();
		var model = new OrderPositionTableModel(cart);
		var product1 = createTestItem(15);
		var product2 = createTestItem(7);
		var product3 = createTestItem(3);

		// when
		cart.addProduct(product1);
		cart.addProduct(product1);
		cart.addProduct(product1);
		cart.addProduct(product2);
		cart.addProduct(product3);

		// then
		assertEquals(3, model.getRowCount());
	}

	@Test
	void testTableModelListenerIsNotifiedOnChange() {
		// given
		var cart = new ShoppingCart();
		var model = new OrderPositionTableModel(cart);
		var product = createTestItem(15);
		var listenerMock = new OrderPositionTableModelObserverMock(model, new TableModelEvent(model));

		// when
		cart.addProduct(product);

		// then
		listenerMock.assertEvents();
	}

	@Test
	void testTableModelListenerIsNotifiedOnEveryChange() {
		// given
		var cart = new ShoppingCart();
		var model = new OrderPositionTableModel(cart);
		var product1 = createTestItem(5);
		var product2 = createTestItem(15);
		var listenerMock = new OrderPositionTableModelObserverMock(model, new TableModelEvent(model),
				new TableModelEvent(model), new TableModelEvent(model));

		// when
		cart.addProduct(product1);
		cart.addProduct(product2);
		cart.addProduct(product2);

		// then
		listenerMock.assertEvents();
	}
}

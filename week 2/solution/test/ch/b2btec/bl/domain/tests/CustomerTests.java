package ch.b2btec.bl.domain.tests;

import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_BUSINESS_NUMBER;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_CUSTOMER_NAME;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_PROFILE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Customer;

class CustomerTests {

	private static Customer createDefaultCustomer() {
		return new Customer(DEFAULT_CUSTOMER_NAME, DEFAULT_BUSINESS_NUMBER, DEFAULT_PROFILE);
	}

	@Test
	void testCustomerHasCorrectName() {
		var customer = createDefaultCustomer();
		assertEquals(DEFAULT_CUSTOMER_NAME, customer.getName());
	}

	@Test
	void testCustomerNameCannotBeNull() {
		assertThrows(IllegalArgumentException.class,
				() -> new Customer(null, DEFAULT_BUSINESS_NUMBER, DEFAULT_PROFILE));
	}

	@Test
	void testCustomerNameCannotBeBlanks() {
		assertThrows(IllegalArgumentException.class,
				() -> new Customer(" \n\t", DEFAULT_BUSINESS_NUMBER, DEFAULT_PROFILE));
	}

	@Test
	void testCustomerHasCorrectBusinessNumber() {
		var customer = createDefaultCustomer();
		assertEquals(DEFAULT_BUSINESS_NUMBER, customer.getBusinessNumber());
	}

	@Test
	void testCustomersBusinessNumberIsNotZero() {
		assertThrows(IllegalArgumentException.class, () -> new Customer(DEFAULT_CUSTOMER_NAME, 0, DEFAULT_PROFILE));
	}

	@Test
	void testCustomersBusinessNumberIsNotNegative() {
		assertThrows(IllegalArgumentException.class, () -> new Customer(DEFAULT_CUSTOMER_NAME, -1, DEFAULT_PROFILE));
	}

	@Test
	void testCustomerHasCorrectProfile() {
		var customer = createDefaultCustomer();
		assertEquals(DEFAULT_PROFILE, customer.getProfile());
	}

	@Test
	void testCustomersProfileCannotBeNull() {
		assertThrows(IllegalArgumentException.class,
				() -> new Customer(DEFAULT_CUSTOMER_NAME, DEFAULT_BUSINESS_NUMBER, null));
	}

	@Test
	void testCustomerGetOrdersIsNotNull() {
		var customer = createDefaultCustomer();
		assertNotNull(customer.getOrders());
	}

	@Test
	void testCustomerGetOrdersIsEmptyForNewCustomer() {
		var customer = createDefaultCustomer();
		var orders = customer.getOrders();
		assertTrue(orders.isEmpty());
	}

	@Test
	void testCustomerCreateOrderReturnsOrder() {
		var customer = createDefaultCustomer();
		var order = customer.createOrder();
		assertNotNull(order);
	}

	@Test
	void testCustomerCreateOrderStoresOrder() {
		var customer = createDefaultCustomer();
		var order = customer.createOrder();
		assertSame(order, customer.getOrders().get(0));
	}
}

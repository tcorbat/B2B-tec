package ch.b2btec.bl.domain.tests;

import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_BUSINESS_NUMBER;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_CUSTOMER_NAME;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_PROFILE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

}

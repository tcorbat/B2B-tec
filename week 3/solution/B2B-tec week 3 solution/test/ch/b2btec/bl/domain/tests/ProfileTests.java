package ch.b2btec.bl.domain.tests;

import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_BILLING_ADDRESS;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_CREDENTIALS;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_DELIVERY_ADDRESS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Profile;

class ProfileTests {

	@Test
	void testProfileKnowsCredentials() {
		var profile = new Profile(DEFAULT_CREDENTIALS, DEFAULT_DELIVERY_ADDRESS, DEFAULT_BILLING_ADDRESS);
		assertEquals(DEFAULT_CREDENTIALS, profile.getCredentials());
	}

	@Test
	void testProfileKnowsDeliveryAddress() {
		var profile = new Profile(DEFAULT_CREDENTIALS, DEFAULT_DELIVERY_ADDRESS, DEFAULT_BILLING_ADDRESS);
		assertEquals(DEFAULT_DELIVERY_ADDRESS, profile.getDeliveryAddress());
	}

	@Test
	void testProfileKnowsBillingAddress() {
		var profile = new Profile(DEFAULT_CREDENTIALS, DEFAULT_DELIVERY_ADDRESS, DEFAULT_BILLING_ADDRESS);
		assertEquals(DEFAULT_BILLING_ADDRESS, profile.getBillingAddress());
	}

	@Test
	void testSameDeliveryAndBillingAddress() {
		var profile = new Profile(DEFAULT_CREDENTIALS, DEFAULT_DELIVERY_ADDRESS);
		assertEquals(DEFAULT_DELIVERY_ADDRESS, profile.getBillingAddress());
	}
}

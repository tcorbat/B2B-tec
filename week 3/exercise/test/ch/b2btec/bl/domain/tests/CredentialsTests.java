package ch.b2btec.bl.domain.tests;

import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_LOGIN_NAME;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Credentials;

class CredentialsTests {

	@Test
	void testSuccessfulConstructionOfCredentials() {
		var credentials = new Credentials(DEFAULT_LOGIN_NAME, DEFAULT_PASSWORD);
		assertEquals(DEFAULT_LOGIN_NAME, credentials.getLoginName());
	}

	@Test
	void testLoginNameCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> new Credentials(null, DEFAULT_PASSWORD));
	}

	@Test
	void testLoginNameCannotBeEmpty() {
		assertThrows(IllegalArgumentException.class, () -> new Credentials("", DEFAULT_PASSWORD));
	}

	@Test
	void testCountryNameCannotHaveBlanks() {
		assertThrows(IllegalArgumentException.class, () -> new Credentials("user name", DEFAULT_PASSWORD));
	}

	@Test
	void testCorrectPasswordIsVerified() {
		var credentials = new Credentials(DEFAULT_LOGIN_NAME, DEFAULT_PASSWORD);
		assertTrue(credentials.verifyPassword(DEFAULT_PASSWORD));
	}

	@Test
	void testInorrectPasswordIsNotVerified() {
		var credentials = new Credentials(DEFAULT_LOGIN_NAME, DEFAULT_PASSWORD);
		assertFalse(credentials.verifyPassword("other"));
	}

	@Test
	void testNullPasswordIsNotVerified() {
		var credentials = new Credentials(DEFAULT_LOGIN_NAME, DEFAULT_PASSWORD);
		assertFalse(credentials.verifyPassword(null));
	}

	@Test
	void testChangedPasswordIsUsed() {
		var newPassword = "Swordfish";

		// given
		var credentials = new Credentials(DEFAULT_LOGIN_NAME, DEFAULT_PASSWORD);

		// when
		credentials.changePassword(DEFAULT_PASSWORD, newPassword);

		// then
		assertTrue(credentials.verifyPassword(newPassword));
	}

	@Test
	void testOldPasswordIsInvalidAfterChange() {
		var newPassword = "Swordfish";

		// given
		var credentials = new Credentials(DEFAULT_LOGIN_NAME, DEFAULT_PASSWORD);

		// when
		credentials.changePassword(DEFAULT_PASSWORD, newPassword);

		// then
		assertFalse(credentials.verifyPassword(DEFAULT_PASSWORD));
	}

	@Test
	void testOldPasswordIsValidAfterIncorrectPasswordIsSuppliedForChange() {
		var newPassword = "Swordfish";

		// given
		var credentials = new Credentials(DEFAULT_LOGIN_NAME, DEFAULT_PASSWORD);

		// when
		credentials.changePassword("incorrect", newPassword);

		// then
		assertTrue(credentials.verifyPassword(DEFAULT_PASSWORD));
	}

	@Test
	void testNewPasswordIsInvalidAfterIncorrectPasswordIsSuppliedForChange() {
		var newPassword = "Swordfish";

		// given
		var credentials = new Credentials(DEFAULT_LOGIN_NAME, DEFAULT_PASSWORD);

		// when
		credentials.changePassword("incorrect", newPassword);

		// then
		assertFalse(credentials.verifyPassword(newPassword));
	}

	@Test
	void testPasswordMustNotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> new Credentials(DEFAULT_LOGIN_NAME, null));
	}

	@Test
	void testPasswordMustNotBeEmpty() {
		assertThrows(IllegalArgumentException.class, () -> new Credentials(DEFAULT_LOGIN_NAME, ""));
	}

	@Test
	void testPasswordMustNotContainWhitespace() {
		assertThrows(IllegalArgumentException.class, () -> new Credentials(DEFAULT_LOGIN_NAME, "pass word"));
	}
}

package ch.b2btec.bl.domain.tests;

import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_CITY_NAME;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_COUNTRY;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_HOUSE_NUMBER;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_STREET_NAME;
import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_ZIP_CODE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Address;

class AddressTests {

	public static AddressBuilder address() {
		return new AddressBuilder();
	}

	private static class AddressBuilder {
		private String streetName = DEFAULT_STREET_NAME;
		private int houseNumber = DEFAULT_HOUSE_NUMBER;
		private int zipCode = DEFAULT_ZIP_CODE;
		private String city = DEFAULT_CITY_NAME;
		private String country = DEFAULT_COUNTRY;

		public AddressBuilder onStreet(String streetName) {
			this.streetName = streetName;
			return this;
		}

		public AddressBuilder inHouseNumber(int houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}

		public AddressBuilder withZipCode(int zipCode) {
			this.zipCode = zipCode;
			return this;
		}

		public AddressBuilder inCity(String city) {
			this.city = city;
			return this;
		}

		public AddressBuilder inCountry(String country) {
			this.country = country;
			return this;
		}

		public Address create() {
			return new Address(streetName, houseNumber, zipCode, city, country);
		}
	}
	
	private Address createDefaultTestAddress() {
		return address().create();
	}

	@Test
	void testDefaultStreetName() {
		var address = createDefaultTestAddress();
		assertEquals(DEFAULT_STREET_NAME, address.getStreetName());
	}

	@Test
	void testDefaultHouseNumber() {
		var address = createDefaultTestAddress();
		assertEquals(DEFAULT_HOUSE_NUMBER, address.getHouseNumber());
	}

	@Test
	void testDefaultZipCode() {
		var address = createDefaultTestAddress();
		assertEquals(DEFAULT_ZIP_CODE, address.getZipCode());
	}

	@Test
	void testDefaultCityName() {
		var address = createDefaultTestAddress();
		assertEquals(DEFAULT_CITY_NAME, address.getCity());
	}

	@Test
	void testDefaultCountry() {
		var address = createDefaultTestAddress();
		assertEquals(DEFAULT_COUNTRY, address.getCountry());
	}
	
	@Test
	void testStreetNameCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> address().onStreet(null).create());
	}

	@Test
	void testStreetNameCannotBeEmpty() {
		assertThrows(IllegalArgumentException.class, () -> address().onStreet("").create());
	}

	@Test
	void testStreetNameCannotBeBlanksOnly() {
		assertThrows(IllegalArgumentException.class, () -> address().onStreet(" \t\n").create());
	}

	@Test
	void testHouseNumberCannotBeNegative() {
		assertThrows(IllegalArgumentException.class, () -> address().inHouseNumber(-1).create());
	}

	@Test
	void testHouseNumberCannotBeZero() {
		assertThrows(IllegalArgumentException.class, () -> address().inHouseNumber(0).create());
	}

	@Test
	void testZipCodeCannotBeNegative() {
		assertThrows(IllegalArgumentException.class, () -> address().withZipCode(-1).create());
	}

	@Test
	void testZipCodeCannotBeZero() {
		assertThrows(IllegalArgumentException.class, () -> address().withZipCode(0).create());
	}

	@Test
	void testCityNameCannotBeNully() {
		assertThrows(IllegalArgumentException.class, () -> address().inCity(null).create());
	}

	@Test
	void testCityNameCannotBeEmpty() {
		assertThrows(IllegalArgumentException.class, () -> address().inCity("").create());
	}

	@Test
	void testCityNameCannotBeBlanksOnly() {
		assertThrows(IllegalArgumentException.class, () -> address().inCity(" \t\n").create());
	}

	@Test
	void testCountryNameCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> address().inCountry(null).create());
	}

	@Test
	void testCountryNameCannotBeEmpty() {
		assertThrows(IllegalArgumentException.class, () -> address().inCountry("").create());
	}

	@Test
	void testCountryNameCannotBeBlanksOnly() {
		assertThrows(IllegalArgumentException.class, () -> address().inCountry(" \t\n").create());
	}
}

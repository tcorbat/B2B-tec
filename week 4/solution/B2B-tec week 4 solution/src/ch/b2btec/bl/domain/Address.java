package ch.b2btec.bl.domain;

public class Address {
	private final String streetName;
	private final int houseNumber;
	private final int zipCode;
	private final String city;
	private final String country;

	public Address(String streetName, int houseNumber, int zipCode, String city, String country) {
		checkStreetName(streetName);
		this.streetName = streetName;
		checkHouseNumber(houseNumber);
		this.houseNumber = houseNumber;
		checkZipCode(zipCode);
		this.zipCode = zipCode;
		checkCityName(city);
		this.city = city;
		checkCountryName(country);
		this.country = country;
	}

	public String getStreetName() {
		return streetName;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public int getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	private static void checkStreetName(String streetName) {
		if (streetName == null || streetName.isBlank()) {
			throw new IllegalArgumentException("Street name must not be empty");
		}
	}

	private static void checkHouseNumber(int houseNumber) {
		if (houseNumber <= 0) {
			throw new IllegalArgumentException("House number cannot be zero or negative");
		}
	}

	private static void checkZipCode(int zipCode) {
		if (zipCode <= 0) {
			throw new IllegalArgumentException("ZIP code cannot be zero or negative");
		}
	}

	private static void checkCityName(String cityName) {
		if (cityName == null || cityName.isBlank()) {
			throw new IllegalArgumentException("City name must not be empty");
		}
	}

	private static void checkCountryName(String countryName) {
		if (countryName == null || countryName.isBlank()) {
			throw new IllegalArgumentException("Country name must not be empty");
		}
	}
}

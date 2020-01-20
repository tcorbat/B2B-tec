package ch.b2btec.bl.domain;

public class Customer {
	private final String name;
	private final int businessNumber;
	private final Profile profile;

	public Customer(String name, int businessNumber, Profile profile) {
		checkCustomerName(name);
		this.name = name;
		checkBusinessNumber(businessNumber);
		this.businessNumber = businessNumber;
		checkNonNull(profile);
		this.profile = profile;
	}

	public String getName() {
		return name;
	}

	public int getBusinessNumber() {
		return businessNumber;
	}

	public Profile getProfile() {
		return profile;
	}

	private static void checkCustomerName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Customer name cannot be null or just blanks");
		}
	}

	private static void checkBusinessNumber(int businessNumber) {
		if (businessNumber <= 0) {
			throw new IllegalArgumentException("Business number cannot be zero or negative");
		}
	}

	private static void checkNonNull(Profile profile) {
		if (profile == null) {
			throw new IllegalArgumentException("Profile must not be null");
		}
	}
}

package ch.b2btec.bl.tests.domain;

import ch.b2btec.bl.domain.Address;
import ch.b2btec.bl.domain.Credentials;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.domain.Profile;

public class DefaultTestValues {

	static final String DEFAULT_STREET_NAME = "Mainstreet";
	static final int DEFAULT_HOUSE_NUMBER = 123;
	static final int DEFAULT_ZIP_CODE = 8000;
	static final String DEFAULT_CITY_NAME = "Zurich";
	static final String DEFAULT_COUNTRY = "Switzerland";
	static final String DEFAULT_CATEGORY_NAME = "Hardware";
	static final String DEFAULT_LOGIN_NAME = "testuser";
	static final String DEFAULT_PASSWORD = "none";
	static String DEFAULT_CUSTOMER_NAME = "Hardware Retail Inc.";
	static final int DEFAULT_BUSINESS_NUMBER = 483;
	static final Credentials DEFAULT_CREDENTIALS = new Credentials("hwret", "admin");
	static final Address DEFAULT_ADDRESS = new Address("Business Street", 12, 11975, "Hammertown", "England");
	static final Profile DEFAULT_PROFILE = new Profile(DEFAULT_CREDENTIALS, DEFAULT_ADDRESS);
	static final int DEFAULT_PRODUCT_NUMBER = 123;
	static final String DEFAULT_PRODUCT_NAME = "Product 123";
	static final int DEFAULT_PRICE = 50;
	static final String DEFAULT_DESCRIPTION = "Description of Product 123";
	static final String DEFAULT_SPECIFICATION = "Specification of Product 123";
	static final Product DEFAULT_PRODUCT = new Product(DEFAULT_PRODUCT_NUMBER, DEFAULT_PRODUCT_NAME, DEFAULT_PRICE,
			DEFAULT_DESCRIPTION, DEFAULT_SPECIFICATION);
	static final Address DEFAULT_DELIVERY_ADDRESS = new Address("Main Street", 42, 1000, "Somewhere", "Wakkanda");
	static final Address DEFAULT_BILLING_ADDRESS = new Address("Second Street", 21, 2000, "Nowhere", "Lalaland");
	final static Customer DEFAULT_CUSTOMER = new Customer(DEFAULT_CUSTOMER_NAME, DEFAULT_BUSINESS_NUMBER,
	DEFAULT_PROFILE);

}

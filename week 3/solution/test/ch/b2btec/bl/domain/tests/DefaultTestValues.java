package ch.b2btec.bl.domain.tests;

import ch.b2btec.bl.domain.Address;
import ch.b2btec.bl.domain.Credentials;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.domain.Profile;

public class DefaultTestValues {

	final static String DEFAULT_STREET_NAME = "Mainstreet";
	final static int DEFAULT_HOUSE_NUMBER = 123;
	final static int DEFAULT_ZIP_CODE = 8000;
	final static String DEFAULT_CITY_NAME = "Zurich";
	final static String DEFAULT_COUNTRY = "Switzerland";
	final static String DEFAULT_CATEGORY_NAME = "Hardware";
	final static String DEFAULT_LOGIN_NAME = "testuser";
	final static String DEFAULT_PASSWORD = "none";
	final static String DEFAULT_CUSTOMER_NAME = "Hardware Retail Inc.";
	final static int DEFAULT_BUSINESS_NUMBER = 483;
	final static Credentials DEFAULT_CREDENTIALS = new Credentials("hwret", "admin");
	final static Address DEFAULT_ADDRESS = new Address("Business Street", 12, 11975, "Hammertown", "England");
	final static Profile DEFAULT_PROFILE = new Profile(DEFAULT_CREDENTIALS, DEFAULT_ADDRESS);
	final static int DEFAULT_PRODUCT_NUMBER = 123;
	final static String DEFAULT_PRODUCT_NAME = "Product 123";
	final static int DEFAULT_PRICE = 50;
	final static String DEFAULT_DESCRIPTION = "Description of Product 123";
	final static String DEFAULT_SPECIFICATION = "Specification of Product 123";
	final static Product DEFAULT_PRODUCT = new Product(DEFAULT_PRODUCT_NUMBER, DEFAULT_PRODUCT_NAME, DEFAULT_PRICE,
			DEFAULT_DESCRIPTION, DEFAULT_SPECIFICATION);
	final static Address DEFAULT_DELIVERY_ADDRESS = new Address("Main Street", 42, 1000, "Somewhere", "Wakkanda");
	final static Address DEFAULT_BILLING_ADDRESS = new Address("Second Street", 21, 2000, "Nowhere", "Lalaland");
	final static Customer DEFAULT_CUSTOMER = new Customer(DEFAULT_CUSTOMER_NAME, DEFAULT_BUSINESS_NUMBER,
	DEFAULT_PROFILE);
	final static int DEFAULT_ORDER_NUMBER = 9080543;

}

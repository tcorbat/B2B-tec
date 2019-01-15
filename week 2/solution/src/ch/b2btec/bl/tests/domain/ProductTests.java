package ch.b2btec.bl.tests.domain;

import static ch.b2btec.bl.tests.domain.DefaultTestValues.DEFAULT_DESCRIPTION;
import static ch.b2btec.bl.tests.domain.DefaultTestValues.DEFAULT_PRODUCT_NAME;
import static ch.b2btec.bl.tests.domain.DefaultTestValues.DEFAULT_PRODUCT_NUMBER;
import static ch.b2btec.bl.tests.domain.DefaultTestValues.DEFAULT_SPECIFICATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Product;

class ProductTests {

	@Test
	void testProductHasNumber() {
		var product = new Product(DEFAULT_PRODUCT_NUMBER, DEFAULT_PRODUCT_NAME, DEFAULT_DESCRIPTION,
				DEFAULT_SPECIFICATION);
		assertEquals(DEFAULT_PRODUCT_NUMBER, product.getProductNumber());
	}

	@Test
	void testProductHasName() {
		var product = new Product(DEFAULT_PRODUCT_NUMBER, DEFAULT_PRODUCT_NAME, DEFAULT_DESCRIPTION,
				DEFAULT_SPECIFICATION);
		assertEquals(DEFAULT_PRODUCT_NAME, product.getName());
	}

	@Test
	void testProductHasDescription() {
		var product = new Product(DEFAULT_PRODUCT_NUMBER, DEFAULT_PRODUCT_NAME, DEFAULT_DESCRIPTION,
				DEFAULT_SPECIFICATION);
		assertEquals(DEFAULT_DESCRIPTION, product.getDescription());
	}

	@Test
	void testProductHasSpecification() {
		var product = new Product(DEFAULT_PRODUCT_NUMBER, DEFAULT_PRODUCT_NAME, DEFAULT_DESCRIPTION,
				DEFAULT_SPECIFICATION);
		assertEquals(DEFAULT_SPECIFICATION, product.getSpecification());
	}

	@Test
	void testProductNumberCannotBeZero() {
		assertThrows(IllegalArgumentException.class,
				() -> new Product(0, DEFAULT_PRODUCT_NAME, DEFAULT_DESCRIPTION, DEFAULT_SPECIFICATION));
	}

	@Test
	void testProductNumberCannotBeNegative() {
		assertThrows(IllegalArgumentException.class,
				() -> new Product(-1, DEFAULT_PRODUCT_NAME, DEFAULT_DESCRIPTION, DEFAULT_SPECIFICATION));
	}

	@Test
	void testLoginNameCannotBeNull() {
		assertThrows(IllegalArgumentException.class,
				() -> new Product(DEFAULT_PRODUCT_NUMBER, null, DEFAULT_DESCRIPTION, DEFAULT_SPECIFICATION));
	}

	@Test
	void testLoginNameCannotBeEmpty() {
		assertThrows(IllegalArgumentException.class,
				() -> new Product(DEFAULT_PRODUCT_NUMBER, "", DEFAULT_DESCRIPTION, DEFAULT_SPECIFICATION));
	}

	@Test
	void testLoginNameCannotBeBlanks() {
		assertThrows(IllegalArgumentException.class,
				() -> new Product(DEFAULT_PRODUCT_NUMBER, " \n\t", DEFAULT_DESCRIPTION, DEFAULT_SPECIFICATION));
	}

	@Test
	void testDescriptionCannotBeNull() {
		assertThrows(IllegalArgumentException.class,
				() -> new Product(DEFAULT_PRODUCT_NUMBER, DEFAULT_PRODUCT_NAME, null, DEFAULT_SPECIFICATION));
	}

	@Test
	void testSpecificationCannotBeNull() {
		assertThrows(IllegalArgumentException.class,
				() -> new Product(DEFAULT_PRODUCT_NUMBER, DEFAULT_PRODUCT_NAME, DEFAULT_DESCRIPTION, null));
	}
}

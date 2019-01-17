package ch.b2btec.bl.tests.domain;

import static ch.b2btec.bl.tests.domain.DefaultTestValues.DEFAULT_CATEGORY_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Category;
import ch.b2btec.bl.domain.Product;

class CategoryTests {

	private static Category createEmptyCategory() {
		return new Category(DEFAULT_CATEGORY_NAME);
	}

	@Test
	void testCategoryHasName() {
		var category = createEmptyCategory();
		assertEquals(DEFAULT_CATEGORY_NAME, category.getName());
	}

	@Test
	void testCategoryNameCannotBeNull() {
		assertThrows(IllegalArgumentException.class, () -> new Category(null));
	}

	@Test
	void testCategoryNameCannotBeEmpty() {
		assertThrows(IllegalArgumentException.class, () -> new Category(""));
	}

	@Test
	void testCategoryNameCannotBeBlanksOnly() {
		assertThrows(IllegalArgumentException.class, () -> new Category(" \n\t"));
	}

	@Test
	void testCategoryWithoutParentHasNoParentCategory() {
		var category = createEmptyCategory();
		assertEquals(null, category.getParentCategory());
	}

	@Test
	void testParentCategoryIsSetCorrectly() {
		var parent = new Category("Parent", null);
		var category = new Category("Sub Category", parent);

		assertEquals(parent, category.getParentCategory());
	}

	@Test
	void testNewCategoryHasNoProducts() {
		var category = createEmptyCategory();
		assertTrue(category.getProducts().isEmpty());
	}

	@Test
	void testCategoryContainsProductAfterAdd() {
		var screw = new Product(1, "Screw", "Goes round", "4mm");
		var expected = Arrays.asList(screw);

		var category = createEmptyCategory();
		category.addProduct(screw);

		assertIterableEquals(expected, category.getProducts());
	}

	@Test
	void testCategoryContainsProductsAfterMultipleAdd() {
		var screw = new Product(1, "Screw", "Goes round", "4mm");
		var nail = new Product(2, "Nail", "Hammered", "1mm");
		var hammer = new Product(3, "Hammer", "Nails", "1kg");
		var expected = Arrays.asList(screw, nail, hammer);

		var category = createEmptyCategory();
		category.addProduct(screw);
		category.addProduct(nail);
		category.addProduct(hammer);

		assertIterableEquals(expected, category.getProducts());
	}
}

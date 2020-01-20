package ch.b2btec.bl.domain.tests;

import static ch.b2btec.bl.domain.tests.DefaultTestValues.DEFAULT_CATEGORY_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Category;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.exceptions.MustNotCreateCategoryCycleException;

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
	void testSubcategoriesAreInitiallyEmpty() {
		var category = createEmptyCategory();
		assertTrue(category.getSubCategories().isEmpty());
	}
	
	@Test
	void testSubcategoryIsAdded() {
		var category = createEmptyCategory();
		var subCategory = createEmptyCategory();
		var expectedSubcategories = Arrays.asList(subCategory);
		category.addSubCategory(subCategory);
		assertIterableEquals(expectedSubcategories, category.getSubCategories());
	}
	
	@Test
	void testMultipleSubcategoriesAreAdded() {
		var parentCategory = createEmptyCategory();
		var subCategory1 = createEmptyCategory();
		var subCategory2 = createEmptyCategory();
		var subCategory3 = createEmptyCategory();
		var expectedSubcategories = Arrays.asList(subCategory1, subCategory2, subCategory3);
		parentCategory.addSubCategory(subCategory1);
		parentCategory.addSubCategory(subCategory2);
		parentCategory.addSubCategory(subCategory3);
		assertIterableEquals(expectedSubcategories, parentCategory.getSubCategories());
	}
	
	@Test
	void testCannotCreateDirectCategoryCycle() {
		var category1 = createEmptyCategory();
		var category2 = createEmptyCategory();
		category1.addSubCategory(category2);
		assertThrows(MustNotCreateCategoryCycleException.class, () -> category2.addSubCategory(category1));
	}
	
	@Test
	void testCannotCreateIndirectCategoryCycle() {
		var category1 = createEmptyCategory();
		var category2 = createEmptyCategory();
		var category3 = createEmptyCategory();
		category1.addSubCategory(category2);
		category2.addSubCategory(category3);
		assertThrows(MustNotCreateCategoryCycleException.class, () -> category3.addSubCategory(category1));
	}

	@Test
	void testNewCategoryHasNoProducts() {
		var category = createEmptyCategory();
		assertTrue(category.getProducts().isEmpty());
	}

	@Test
	void testCategoryContainsProductAfterAdd() {
		var screw = new Product(1, "Screw", 2, "Goes round", "4mm");
		var expected = Arrays.asList(screw);

		var category = createEmptyCategory();
		category.addProduct(screw);

		assertIterableEquals(expected, category.getProducts());
	}

	@Test
	void testCategoryContainsProductsAfterMultipleAdd() {
		var screw = new Product(1, "Screw", 2, "Goes round", "4mm");
		var nail = new Product(2, "Nail", 1, "Hammered", "1mm");
		var hammer = new Product(3, "Hammer", 15, "Nails", "1kg");
		var expected = Arrays.asList(screw, nail, hammer);

		var category = createEmptyCategory();
		category.addProduct(screw);
		category.addProduct(nail);
		category.addProduct(hammer);

		assertIterableEquals(expected, category.getProducts());
	}
}

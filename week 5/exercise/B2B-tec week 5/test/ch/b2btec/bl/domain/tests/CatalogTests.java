package ch.b2btec.bl.domain.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.Price;
import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Category;
import ch.b2btec.bl.domain.Product;

class CatalogTests {

	@Test
	void testNewCatalogIsEmpty() {
		var catalog = new Catalog();

		assertTrue(catalog.getCategories().isEmpty());
	}

	@Test
	void testCatalogContainsAddedCategories() {
		var tools = new Category("Tools");
		var drills = new Category("Drills");
		tools.addSubCategory(drills);
		var paint = new Category("Paint");

		var expected = Arrays.asList(tools, paint);

		var catalog = new Catalog();
		catalog.addCategory(tools);
		catalog.addCategory(paint);

		assertIterableEquals(expected, catalog.getCategories());
	}

	@Test
	void testCatalogContainsEveryProductOnce() {
		var screw = new Product(1, "Screw", new Price(2), "Goes round", "4mm");
		var nail = new Product(2, "Nail", new Price(1), "Hammered", "1mm");
		var hammer = new Product(3, "Hammer", new Price(15), "Nails", "1kg");
		var expected = Arrays.asList(screw, nail, hammer);

		var catalog = new Catalog();
		catalog.addProduct(screw);
		catalog.addProduct(nail);
		catalog.addProduct(hammer);

		assertIterableEquals(expected, catalog.getProducts());
	}
	
	@Test
	void testFindParentCategoryForRootCategory() {
		var category = new Category("Saws");
		var catalog = new Catalog();
		catalog.addCategory(category);
		assertTrue(catalog.getParentCategory(category).isEmpty());
	}

	@Test
	void testParentCategoryIsSetCorrectly() {
		var parent = new Category("Parent");
		var category = new Category("Sub Category");
		parent.addSubCategory(category);
		var catalog = new Catalog();
		catalog.addCategory(parent);

		assertEquals(parent, catalog.getParentCategory(category).get());
	}
}

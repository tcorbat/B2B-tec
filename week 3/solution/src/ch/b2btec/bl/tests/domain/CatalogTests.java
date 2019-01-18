package ch.b2btec.bl.tests.domain;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

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
		var drills = new Category("Drills", tools);
		var paint = new Category("Paint");

		var expected = Arrays.asList(tools, drills, paint);

		var catalog = new Catalog();
		catalog.addCategory(tools);
		catalog.addCategory(drills);
		catalog.addCategory(paint);

		assertIterableEquals(expected, catalog.getCategories());
	}

	@Test
	void testCatalogContainsEveryProductOnce() {
		var screw = new Product(1, "Screw", 2, "Goes round", "4mm");
		var nail = new Product(2, "Nail", 1, "Hammered", "1mm");
		var hammer = new Product(3, "Hammer", 15, "Nails", "1kg");
		var expected = Arrays.asList(screw, nail, hammer);

		var catalog = new Catalog();
		catalog.addProduct(screw);
		catalog.addProduct(nail);
		catalog.addProduct(hammer);

		assertIterableEquals(expected, catalog.getProducts());
	}
}

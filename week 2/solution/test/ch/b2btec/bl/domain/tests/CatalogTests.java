package ch.b2btec.bl.domain.tests;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.Price;
import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Category;
import ch.b2btec.bl.domain.Product;

class CatalogTests {

	@Test
	void testNewCatalogCategoriesIsEmpty() {
		var catalog = new Catalog();
		assertTrue(catalog.getCategories().isEmpty());
	}

	@Test
	void testNewCatalogProductsIsEmpty() {
		var catalog = new Catalog();
		assertTrue(catalog.getProducts().isEmpty());
	}

	@Test
	void testCatalogContainsAddedCategories() {
		var peripherals = new Category("Peripherals");
		var keyboards = new Category("Keyboards", peripherals);
		var processors = new Category("Processors");

		var expected = Arrays.asList(keyboards, peripherals, processors);

		var catalog = new Catalog();
		catalog.addCategory(peripherals);
		catalog.addCategory(keyboards);
		catalog.addCategory(processors);

		assertIterableEquals(expected, catalog.getCategories());
	}

	@Test
	void testCatalogContainsEveryProductOnce() {
		var rtx2080 = new Product(1, "GeForce RTX 2080 Ti", new Price(1300), "Raytraces", "11GB RAM");
		var rx570 = new Product(2, "Radeon RX 570 XT", new Price(479), "Renders screen", "8GB RAM");
		var gtx1050 = new Product(3, "GeForce GTX 1050", new Price(164), "Works too", "4GB RAM");
		var expected = Arrays.asList(rtx2080, rx570, gtx1050);

		var catalog = new Catalog();
		catalog.addProduct(rtx2080);
		catalog.addProduct(rx570);
		catalog.addProduct(gtx1050);

		assertIterableEquals(expected, catalog.getProducts());
	}

	@Test
	void testCatalogCreateProductCreatesProduct() {
		var catalog = new Catalog();
		var product = catalog.createProduct("BlueRay Burner", new Price(79), "Burns BlueRay discs", "Speed 4x");
		assertNotNull(product);
	}

	@Test
	void testCatalogCreatedProductsHaveDifferentNumbers() {
		var catalog = new Catalog();
		var blueray = catalog.createProduct("BlueRay Burner", new Price(79), "Burns BlueRay discs", "Speed 4x");
		var dvddrive = catalog.createProduct("DVD Drive", new Price(49), "Reads CDs and DVDs", "Speed 40x/16x");
		assertNotEquals(blueray.getProductNumber(), dvddrive.getProductNumber());
	}

	@Test
	void testCatalogAddProductWithExistingNumberThrows() {
		var catalog = new Catalog();
		var blueray = catalog.createProduct("BlueRay Burner", new Price(79), "Burns BlueRay discs", "Speed 4x");
		var dvddrive = new Product(blueray.getProductNumber(), "DVD Drive", new Price(49), "Reads CDs and DVDs", "Speed 40x/16x");
		assertThrows(IllegalArgumentException.class, () -> catalog.addProduct(dvddrive));
	}
}

package ch.b2btec.bl.visitor.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Category;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.visitor.CatalogItem;
import ch.b2btec.bl.visitor.CatalogPrintVisitor;

class CatalogPrintVisitorTests {

	private static String runVisitor(CatalogItem item) {
		var output = new ByteArrayOutputStream();
		var printStream = new PrintStream(output);
		var visitor = new CatalogPrintVisitor(printStream);
		item.accept(visitor);
		return output.toString().replaceAll("\\r", "");
	}

	@Test
	void testPrintSingleProduct() {
		var product = new Product(1, "Pen", 2, "Writes on paper", "Color: black");
		var outputString = runVisitor(product);
		assertEquals("Pen costs 2$\n", outputString);
	}
	
	@Test
	void testPrintSingleCategory() throws Exception {
		var category = new Category("Writing Materials");
		var outputString = runVisitor(category);
		assertEquals("Category: Writing Materials\n", outputString);
	}

	@Test
	void testPrintEmptyCatalog() throws Exception {
		var catalog = new Catalog();
		var outputString = runVisitor(catalog);
		assertEquals("Catalog\n", outputString);
	}

	@Test
	void testPrintCatalogProducts() throws Exception {
		var catalog = new Catalog();
		catalog.addProduct(new Product(1, "Pen", 2, "Writes", "Color: blue"));
		catalog.addProduct(new Product(2, "Pencil", 1, "Writes", "Color: black"));
		var outputString = runVisitor(catalog);
		assertEquals("Catalog\n" +
					 "\tPen costs 2$\n" +
					 "\tPencil costs 1$\n", outputString);
	}

	@Test
	void testPrintCatalogCategories() throws Exception {
		var catalog = new Catalog();
		catalog.addCategory(new Category("Writing Materials"));
		catalog.addCategory(new Category("Paper"));
		var outputString = runVisitor(catalog);
		assertEquals("Catalog\n" +
					 "\tCategory: Writing Materials\n" +
					 "\tCategory: Paper\n", outputString);
	}
	
	@Test
	void testPrintCatalogMixed() throws Exception {
		var catalog = new Catalog();
		Category writingMaterials = new Category("Writing Materials");
		catalog.addCategory(writingMaterials);
		writingMaterials.addProduct(new Product(1, "Pen", 2, "Writes", "Color: blue"));
		writingMaterials.addProduct(new Product(2, "Pencil", 1, "Writes", "Color: black"));
		Category brushes = new Category("Brushes");
		brushes.addProduct(new Product(4, "Frog Hair Brush", 10, "Paints very thin lines", "Mystical"));
		writingMaterials.addSubCategory(brushes);
		Category paper = new Category("Paper");
		catalog.addCategory(paper);
		paper.addProduct(new Product(5, "Sheet of Paper", 1, "Can be written", "White A4"));
		catalog.addProduct(new Product(3, "Eraser", 3, "Unwrites", "For pencils"));
		var outputString = runVisitor(catalog);
		assertEquals("Catalog\n" +
				 	 "\tEraser costs 3$\n" +
					 "\tCategory: Writing Materials\n" +
					 "\t\tPen costs 2$\n" +
					 "\t\tPencil costs 1$\n" +
					 "\t\tCategory: Brushes\n" +
					 "\t\t\tFrog Hair Brush costs 10$\n" +
					 "\tCategory: Paper\n" +
					 "\t\tSheet of Paper costs 1$\n", outputString);
	}
}

package ch.b2btec;

import java.io.IOException;

import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Category;
import ch.b2btec.bl.domain.Product;

public class Application {

	public static void main(String[] args) {
		try {
			var catalog = Catalog.loadCatalog();
			System.out.println("Catalog loaded successfully.");
			printCatalog(catalog);
		} catch (IOException e) {
			System.err.println("Error loading catalog");
			e.printStackTrace();
		}
	}
	
	private static void printCatalog(Catalog catalog) {
		System.out.println("Categories:");
		catalog.getCategories().stream().map(Category::getName).map(s -> s.indent(1)).forEach(System.out::print);
		System.out.println("Products:");
		catalog.getProducts().stream().map(Product::getName).map(s -> s.indent(1)).forEach(System.out::print);
	}
}

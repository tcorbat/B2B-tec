package ch.b2btec.bl.domain;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.GsonBuilder;

import ch.b2btec.bl.Price;

public class Catalog {
	private static int nextProductNumber = 1;
	private final Map<String, Category> categories = new TreeMap<>();
	private final Map<Integer, Product> products = new TreeMap<>();

	public Collection<Category> getCategories() {
		return Collections.unmodifiableCollection(categories.values());
	}

	public void addCategory(Category category) {
		categories.put(category.getName(), category);
	}

	public Collection<Product> getProducts() {
		return Collections.unmodifiableCollection(products.values());
	}

	public void addProduct(Product product) {
		var number = product.getProductNumber();
		if (products.containsKey(number)) {
			throw new IllegalArgumentException("Product with number " + number + " already exists");
		}
		products.put(product.getProductNumber(), product);
	}

	public Product createProduct(String name, Price price, String description, String specification) {
		var product = new Product(determineNextFreeProductNumber(), name, price, description, specification);
		addProduct(product);
		return product;
	}

	private int determineNextFreeProductNumber() {
		while (products.containsKey(nextProductNumber)) {
			nextProductNumber++;
		}
		return nextProductNumber++;
	}
	
	public static Catalog loadCatalog() throws IOException {
		var catalogFile = new File("predefined/catalog.json");
		try (var reader = new FileReader(catalogFile)) {
			var builder = new GsonBuilder();
			var gson = builder.create();
			return gson.fromJson(reader, Catalog.class);
		}
	}
}

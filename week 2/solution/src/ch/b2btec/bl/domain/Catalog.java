package ch.b2btec.bl.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalog {
	private final ArrayList<Category> categories = new ArrayList<>();
	private final ArrayList<Product> products = new ArrayList<>();

	public List<Category> getCategories() {
		return Collections.unmodifiableList(categories);
	}

	public void addCategory(Category category) {
		categories.add(category);
	}

	public List<Product> getProducts() {
		return Collections.unmodifiableList(products);
	}

	public void addProduct(Product product) {
		products.add(product);
	}
}

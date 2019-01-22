package ch.b2btec.bl.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Category {
	private final String name;
	private final Category parentCategory;
	private final ArrayList<Product> products = new ArrayList<>();

	public Category(String name, Category parentCategory) {
		checkCategoryName(name);
		this.name = name;
		this.parentCategory = parentCategory;
	}

	public Category(String name) {
		this(name, null);
	}

	public String getName() {
		return name;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public List<Product> getProducts() {
		return Collections.unmodifiableList(products);
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	private static void checkCategoryName(String categoryName) {
		if (categoryName == null || categoryName.isBlank()) {
			throw new IllegalArgumentException("Category name cannot be null or just blanks");
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}

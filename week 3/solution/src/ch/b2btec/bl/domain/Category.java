package ch.b2btec.bl.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.b2btec.bl.exceptions.MustNotCreateCategoryCycleException;

public class Category {
	private final String name;
	private final ArrayList<Product> products = new ArrayList<>();
	private final ArrayList<Category> subCategories = new ArrayList<>();

	public Category(String name) {
		checkCategoryName(name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Product> getProducts() {
		return Collections.unmodifiableList(products);
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public List<Category> getSubCategories() {
		return Collections.unmodifiableList(subCategories);
	}

	public void addSubCategory(Category subCategory) {
		checkNoCycle(subCategory);
		subCategories.add(subCategory);
	}

	private void checkNoCycle(Category subCategory) {
		if (subCategory.findInSubcategories(this)) {
			throw new MustNotCreateCategoryCycleException();
		}
	}
	
	private boolean findInSubcategories(Category categoryToFind) {
		return subCategories.stream().anyMatch(category -> category == categoryToFind || category.findInSubcategories(categoryToFind));
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

package ch.b2btec.bl.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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

	public Optional<Category> getParentCategory(Category category) {
		return findParentCategory(categories, category);
	}
	
	private static Optional<Category> findParentCategory(List<Category> potentialParents, Category category) {
		Optional<Category> parent = potentialParents.stream().filter(potentialParent -> isDirectChild(potentialParent, category)).findFirst();
		if (parent.isPresent()) {
			return parent;
		}
		return potentialParents.stream().map(sub -> findParentCategory(sub.getSubCategories(), category)).flatMap(Optional::stream).findFirst();
	}
	
	private static boolean isDirectChild(Category parent, Category child) {
		return parent.getSubCategories().stream().anyMatch(category -> category == child);
	}
}

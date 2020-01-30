package ch.b2btec.bl.domain;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import ch.b2btec.bl.Price;
import ch.b2btec.bl.visitor.CatalogItem;
import ch.b2btec.bl.visitor.CatalogItemVisitor;

public class Catalog implements CatalogItem {

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


	public Optional<Category> getParentCategory(Category category) {
		return findParentCategory(categories.values(), category);
	}
	
	private static Optional<Category> findParentCategory(Collection<Category> potentialParents, Category category) {
		Optional<Category> parent = potentialParents.stream().filter(potentialParent -> isDirectChild(potentialParent, category)).findFirst();
		if (parent.isPresent()) {
			return parent;
		}
		return potentialParents.stream().map(sub -> findParentCategory(sub.getSubCategories(), category)).flatMap(Optional::stream).findFirst();
	}
	
	private static boolean isDirectChild(Category parent, Category child) {
		return parent.getSubCategories().stream().anyMatch(category -> category == child);
	}

	@Override
	public void accept(CatalogItemVisitor visitor) {
		visitor.visit(this);
		products.values().forEach(product -> product.accept(visitor));
		categories.values().forEach(category -> category.accept(visitor));
		visitor.leave(this);
	}
}

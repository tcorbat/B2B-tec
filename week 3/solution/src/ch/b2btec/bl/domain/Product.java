package ch.b2btec.bl.domain;

public class Product {
	private final int productNumber;
	private final String name;
	private final int price;
	private final String description;
	private final String specification;

	public Product(int productNumber, String name, int price, String description, String specification) {
		checkProductNumber(productNumber);
		this.productNumber = productNumber;
		checkProductName(name);
		this.name = name;
		checkPrice(price);
		this.price = price;
		checkProductDescription(description);
		this.description = description;
		checkProductSpecification(specification);
		this.specification = specification;
	}

	public int getProductNumber() {
		return productNumber;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getSpecification() {
		return specification;
	}

	public int getPrice() {
		return price;
	}

	private static void checkProductNumber(int productNumber) {
		if (productNumber <= 0) {
			throw new IllegalArgumentException("Product number cannot be zero or negative");
		}
	}

	private static void checkProductName(String name) {
		if (name == null || name.isBlank()) {
			throw new IllegalArgumentException("Product name cannot be null or just blanks");
		}
	}

	private void checkPrice(int price) {
		if (price < 0) {
			throw new IllegalArgumentException("Product price cannot be below zero");
		}
	}

	private static void checkProductDescription(String description) {
		if (description == null) {
			throw new IllegalArgumentException("Product description cannot be null");
		}
	}

	private static void checkProductSpecification(String specification) {
		if (specification == null) {
			throw new IllegalArgumentException("Product specification cannot be null");
		}
	}
	
	@Override
	public String toString() {
		return name;
	}
}

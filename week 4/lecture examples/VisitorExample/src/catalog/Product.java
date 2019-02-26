package catalog;

import java.net.URI;

import catalog.visitor.CatalogItemVisitor;

public class Product implements CatalogItem {
	private final String name;
	private final int price;
	private final String description;
	private final URI image;

	public Product(String name, int price, String description, URI image) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
	}

	@Override
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public URI getImage() {
		return image;
	}

	@Override
	public void accept(CatalogItemVisitor visitor) {
		visitor.visit(this);
	}
}

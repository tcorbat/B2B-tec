package catalog;

import java.io.PrintStream;
import java.net.URI;

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
	public void display(PrintStream stream) {
		stream.println("Product: " + name + " costs $" + price);
	}
}

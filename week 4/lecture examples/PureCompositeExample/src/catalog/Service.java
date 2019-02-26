package catalog;

import java.io.PrintStream;

public class Service implements CatalogItem {
	private final String name;
	private final int price;
	private final String description;

	public Service(String name, int price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}

	@Override
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public String getDescription() {
		return this.description;
	}

	@Override
	public void display(PrintStream stream) {
		stream.println("Service: " + name + " costs $" + price);
	}
}

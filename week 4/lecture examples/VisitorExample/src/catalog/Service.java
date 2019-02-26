package catalog;

import catalog.visitor.CatalogItemVisitor;

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
	public void accept(CatalogItemVisitor visitor) {
		visitor.visit(this);
	}
}

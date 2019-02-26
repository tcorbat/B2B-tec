package catalog;

import java.util.ArrayList;
import java.util.List;

import catalog.visitor.CatalogItemVisitor;

public class Category implements CatalogItem {
	private final List<CatalogItem> items = new ArrayList<>();
	private final String name;

	public Category(String name) {
		this.name = name;
	}

	public void addItem(CatalogItem item) {
		items.add(item);
	}

	public void removeItem(CatalogItem item) {
		items.remove(item);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void accept(CatalogItemVisitor visitor) {
		visitor.visit(this);
		items.forEach(item -> item.accept(visitor));
	}
}

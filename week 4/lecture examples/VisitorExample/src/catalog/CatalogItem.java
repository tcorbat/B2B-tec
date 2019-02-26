package catalog;

import catalog.visitor.CatalogItemVisitor;

public interface CatalogItem {
	String getName();

	void accept(CatalogItemVisitor visitor);
}

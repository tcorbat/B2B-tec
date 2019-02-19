package ch.b2btec.bl.visitor;

import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Category;
import ch.b2btec.bl.domain.Product;

public interface CatalogItemVisitor {

	void visit(Catalog catalog);
	void leave(Catalog catalog);

	void visit(Product product);
	void leave(Product product);

	void visit(Category category);
	void leave(Category category);

}

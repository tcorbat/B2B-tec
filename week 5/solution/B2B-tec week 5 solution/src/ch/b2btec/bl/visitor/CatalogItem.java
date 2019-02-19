package ch.b2btec.bl.visitor;

public interface CatalogItem {
	void accept(CatalogItemVisitor visitor);
}

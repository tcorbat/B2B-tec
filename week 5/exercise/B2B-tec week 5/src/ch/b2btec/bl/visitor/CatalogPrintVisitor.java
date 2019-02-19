package ch.b2btec.bl.visitor;

import java.io.PrintStream;
import java.text.MessageFormat;

import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Category;
import ch.b2btec.bl.domain.Product;

public class CatalogPrintVisitor implements CatalogItemVisitor {

	private static final String PRODUCT_FORMAT = "{0} costs {1}";
	private static final String CATEGORY_FORMAT = "Category: {0}";
	private static final String CATALOG_FORMAT = "Catalog";
	private static final String INDENTATION = "\t";

	private final PrintStream printStream;
	private int indentationLevel = 0;

	public CatalogPrintVisitor(PrintStream printStream) {
		this.printStream = printStream;
	}

	@Override
	public void visit(Catalog catalog) {
		printStream.println(CATALOG_FORMAT);
		indentationLevel++;
	}

	@Override
	public void leave(Catalog catalog) {
		indentationLevel--;
	}

	@Override
	public void visit(Product product) {
		printIndentation();
		printStream.println(MessageFormat.format(PRODUCT_FORMAT, product.getName(), product.getPrice()));
	}

	@Override
	public void leave(Product product) {
	}

	@Override
	public void visit(Category category) {
		printIndentation();
		printStream.println(MessageFormat.format(CATEGORY_FORMAT, category.getName()));
		indentationLevel++;
	}

	@Override
	public void leave(Category category) {
		indentationLevel--;
	}

	private void printIndentation() {
		for (int level = 0; level < indentationLevel; level++) {
			printStream.print(INDENTATION);
		}
	}
}

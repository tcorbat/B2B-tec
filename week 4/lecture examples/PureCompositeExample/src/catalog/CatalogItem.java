package catalog;

import java.io.PrintStream;

public interface CatalogItem {
	String getName();

	void display(PrintStream stream);
}

package ch.b2btec.bl;

import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Category;

public class CatalogManagementService implements CatalogManagement {

	@Override
	public Catalog getCatalog() {

		Catalog catalog = new Catalog();
		Category hardware = new Category("Hardware");
		Category services = new Category("Services");
		Category components = new Category("Components", hardware);
		catalog.addCategory(hardware);
		catalog.addCategory(services);
		catalog.addCategory(components);
		return catalog;
	}

}

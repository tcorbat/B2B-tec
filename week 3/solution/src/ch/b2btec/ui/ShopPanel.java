package ch.b2btec.ui;

import javax.swing.JPanel;
import javax.swing.JTree;

import ch.b2btec.bl.CatalogManagement;
import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.ui.generated.ShopPanelBase;

public class ShopPanel extends ShopPanelBase<Product, CatalogManagement> {

	private static final long serialVersionUID = 1562773625035679136L;

	public ShopPanel(CatalogManagement catalogManagement) {
		super(catalogManagement);
	}

	@Override
	protected JPanel createDetailsPanel() {
		return new ProductPanel();
	}
	
	@Override
	protected void configureCategoryTree(JTree categoryTree, CatalogManagement catalogManagement) {
		categoryTree.setShowsRootHandles(true);
		categoryTree.setRootVisible(false);
		Catalog catalog = catalogManagement.getCatalog();
		categoryTree.setModel(new CatalogTreeModel(catalog));
	}
}

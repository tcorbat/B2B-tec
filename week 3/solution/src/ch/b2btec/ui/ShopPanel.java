package ch.b2btec.ui;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;

import ch.b2btec.bl.CatalogManagement;
import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.ui.generated.ShopPanelBase;
import ch.b2btec.ui.models.ProductModel;

public class ShopPanel extends ShopPanelBase<Product, CatalogManagement> {

	private static final long serialVersionUID = 1562773625035679136L;
	private ProductModel productPanelModel;

	public ShopPanel(CatalogManagement catalogManagement) {
		super(catalogManagement);
	}

	@Override
	protected JPanel createDetailsPanel() {
		productPanelModel = new ProductModel();
		return new ProductPanel(productPanelModel);
	}

	@Override
	protected void configureCategoryTree(JTree categoryTree, CatalogManagement catalogManagement) {
		categoryTree.setShowsRootHandles(true);
		categoryTree.setRootVisible(false);
		Catalog catalog = catalogManagement.getCatalog();
		categoryTree.setModel(new CatalogTreeModel(catalog));
		categoryTree.addTreeSelectionListener(this::treeSelectionChanged);
	}

	private void treeSelectionChanged(TreeSelectionEvent event) {
		Object source = event.getSource();
		if (source instanceof JTree) {
			var tree = (JTree) source;
			var selectedItem = tree.getLastSelectedPathComponent();
			if (selectedItem instanceof Product) {
				var product = (Product) selectedItem;
				productPanelModel.showProduct(product);
			} else {
				productPanelModel.clear();
			}
		}
	}
}

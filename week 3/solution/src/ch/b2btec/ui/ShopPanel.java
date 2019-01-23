package ch.b2btec.ui;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;

import ch.b2btec.bl.CatalogManagement;
import ch.b2btec.bl.OrderManagement;
import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.ui.generated.ShopPanelBase;
import ch.b2btec.ui.models.OrderPositionTableModel;
import ch.b2btec.ui.models.ShopModel;
import ch.b2btec.ui.models.ShopModel.Property;

public class ShopPanel extends ShopPanelBase<Customer, Product, OrderManagement, CatalogManagement> {

	private static final long serialVersionUID = 1562773625035679136L;
	private ShopModel shopModel;

	public ShopPanel(Customer customer, OrderManagement orderManagement, CatalogManagement catalogManagement) {
		super(customer, orderManagement, catalogManagement);
		shopModel.addPropertyChangeListener(this::updateState);
		addToCartButton.addActionListener(this::addToCartClicked);
		var customersOrders = orderManagement.getOrders(customer);
		shoppingCartPanel.setTableModel(new OrderPositionTableModel(customersOrders.get(0).getCart()));
	}

	@Override
	protected JPanel createDetailsPanel(Customer customer, OrderManagement orderManagement) {
		shopModel = new ShopModel(customer, orderManagement);
		return new ProductPanel(shopModel.getProductDetailModel());
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
				shopModel.showProduct(product);
			} else {
				shopModel.clearProduct();
			}
		}
	}
	
	private void updateState(PropertyChangeEvent event) {
		var changedProperty = Property.valueOf(event.getPropertyName());
		if (changedProperty == Property.ProductSelected) {
			addToCartButton.setEnabled(shopModel.isAddToCartEnabled());
		}
	}
	
	private void addToCartClicked(ActionEvent event) {
		shopModel.addSelectedProductToCart();
	}
}

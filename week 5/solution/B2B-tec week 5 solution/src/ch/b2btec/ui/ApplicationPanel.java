package ch.b2btec.ui;


import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.services.CatalogManagement;
import ch.b2btec.bl.services.OrderManagement;
import ch.b2btec.bl.services.UserManagement;
import ch.b2btec.ui.generated.ApplicationPanelBase;
import ch.b2btec.ui.models.ShoppingCartModel;

public class ApplicationPanel
		extends ApplicationPanelBase<Customer, OrderManagement, CatalogManagement, UserManagement> {
	private static final long serialVersionUID = 1547788347753286322L;

	public ApplicationPanel(Customer customer, OrderManagement orderManagement, CatalogManagement catalogManagement, UserManagement userManagement) {
		super(customer, orderManagement, catalogManagement, userManagement);
	}

	@Override
	protected JPanel createShopTab(Customer customer, OrderManagement orderManagement, CatalogManagement catalogManagement) {
		return new ShopPanel(customer, orderManagement, catalogManagement);
	}

	@Override
	protected JPanel createOrdersTab(Customer customer, OrderManagement orderManagement) {
		return new OrdersPanel(customer, orderManagement);
	}

	@Override
	protected JPanel createOverviewPanel(Customer customer, OrderManagement orderManagement) {
		var orders = orderManagement.getOrders(customer);
		var shoppingCartSummary = new ShoppingCartSummaryPanel(new ShoppingCartModel(orders.get(0).getCart()));
		shoppingCartSummary.setBorder(new TitledBorder("Shopping Cart Summary"));
		return shoppingCartSummary;
	}

	@Override
	protected JPanel createProfileTab(UserManagement userManagement, Customer customer) {
		return new ProfileTabPanel(userManagement, customer);
	}
}

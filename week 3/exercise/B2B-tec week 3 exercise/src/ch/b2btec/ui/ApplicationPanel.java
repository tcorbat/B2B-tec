package ch.b2btec.ui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.services.CatalogManagement;
import ch.b2btec.bl.services.OrderManagement;
import ch.b2btec.ui.generated.ApplicationPanelBase;
import ch.b2btec.ui.models.AddressModel;
import ch.b2btec.ui.models.ShoppingCartModel;

public class ApplicationPanel extends ApplicationPanelBase<Customer, OrderManagement, CatalogManagement> {
	private static final long serialVersionUID = 1547788347753286322L;

	public ApplicationPanel(Customer customer, OrderManagement orderManagement, CatalogManagement catalogManagement) {
		super(customer, orderManagement, catalogManagement);
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
	protected JPanel createProfileTab(Customer customer) {
		var profilePanel = new JPanel();

		var detailsPanel = new JPanel();
		detailsPanel.setBorder(new TitledBorder("User Details"));
		detailsPanel.setLayout(new GridLayout(2, 2, 5, 5));
		detailsPanel.add(new JLabel("Customer Name:"));
		detailsPanel.add(new JLabel(customer.getName()));
		detailsPanel.add(new JLabel("Business Number:"));
		detailsPanel.add(new JLabel(Integer.toString(customer.getBusinessNumber())));
		profilePanel.add(detailsPanel);

		var deliveryAddress = new AddressPanel(new AddressModel(customer.getProfile().getDeliveryAddress()));
		deliveryAddress.setBorder(new TitledBorder("Delivery Address"));
		profilePanel.add(deliveryAddress);

		var billingAddress = new AddressPanel(new AddressModel(customer.getProfile().getDeliveryAddress()));
		billingAddress.setBorder(new TitledBorder("Billing Address"));
		profilePanel.add(billingAddress);

		return profilePanel;
	}

}

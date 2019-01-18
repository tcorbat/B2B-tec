package ch.b2btec.ui;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import ch.b2btec.bl.OrderManagement;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.ui.models.AddressModel;
import ch.b2btec.ui.models.ShoppingCartModel;

public class ShopPanel extends JPanel {
	private static final long serialVersionUID = 1547788347753286322L;

	public ShopPanel(Customer customer, OrderManagement orderManagement) {
		setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
		var orders = orderManagement.getOrders(customer);
		add(new ShoppingCartSummaryPanel(new ShoppingCartModel(orders.get(0).getCart())));
		add(new AddressPanel(new AddressModel(customer.getProfile().getDeliveryAddress())));
		add(new AddressPanel(new AddressModel(customer.getProfile().getBillingAddress())));
	}

}

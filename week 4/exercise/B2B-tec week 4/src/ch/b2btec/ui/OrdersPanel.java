package ch.b2btec.ui;

import java.util.List;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Order;
import ch.b2btec.bl.domain.ShoppingCart;
import ch.b2btec.bl.services.OrderManagement;
import ch.b2btec.ui.generated.OrdersPanelBase;
import ch.b2btec.ui.models.OrderPositionTableModel;

public class OrdersPanel extends OrdersPanelBase<Order> {

	private static final long serialVersionUID = -3764332333191022966L;
	private final Customer customer;
	private final OrderManagement orderManagement;

	private static final class OrderListModel implements ListModel<Order> {

		private List<Order> orders;

		public OrderListModel(List<Order> orders) {
			this.orders = orders;
		}

		@Override
		public int getSize() {
			return orders.size();
		}

		@Override
		public Order getElementAt(int index) {
			return orders.get(index);
		}

		@Override
		public void addListDataListener(ListDataListener l) {
		}

		@Override
		public void removeListDataListener(ListDataListener l) {
		}
	}
	
	public OrdersPanel(Customer customer, OrderManagement orderManagement) {
		this.customer = customer;
		this.orderManagement = orderManagement;
		updateOrdersOverview();
		orderList.addListSelectionListener(selectionEvent -> {
			var selectedOrder = orderList.getSelectedValue();
			updateOrderDetails(selectedOrder);
		});
	}

	private void updateOrdersOverview() {
		var orders = orderManagement.getOrders(customer);
		orderList.setModel(new OrderListModel(orders));
	}

	private void updateOrderDetails(Order order) {
		if (order == null) {
			resetOrderDetails();
			return;
		}
		orderNumberLabel.setText(Integer.toString(order.getOrderNumber()));
		orderPriceLabel.setText(Integer.toString(getTotalPrice(order.getCart())));
		orderDateLabel.setText("unknown date");
		orderStateLabel.setText(order.getState().name());
		orderItemsPanel.setTableModel(new OrderPositionTableModel(order.getCart()));
	}

	private void resetOrderDetails() {
		orderNumberLabel.setText("");
		orderPriceLabel.setText("");
		orderDateLabel.setText("");
		orderStateLabel.setText("");
		orderItemsPanel.clearTableModel();

	}

	public int getTotalPrice(ShoppingCart cart) {
		return cart.getPositions().stream()
				.mapToInt(position -> position.getQuantity() * position.getProduct().getPrice()).sum();
	}
}

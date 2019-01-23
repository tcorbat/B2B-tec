package ch.b2btec.ui.generated;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class OrdersPanelBase<E> extends JPanel {

	private static final long serialVersionUID = 2342306099763855259L;
	protected static final DefaultTableModel DEFAULT_TABLE_MODEL = new DefaultTableModel(new Object[][] {},
			new String[] { "Name", "Number", "Quantity", "Price Each", "Price Total" });
	protected JList<E> orderList;
	protected JLabel orderNumberLabel;
	protected JLabel orderPriceLabel;
	protected JLabel orderDateLabel;
	protected JLabel orderStateLabel;
	protected JPanel orderItemsPanel;

	public OrdersPanelBase() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 150, 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0 };
		setLayout(gridBagLayout);

		JPanel orderDetailsPanel = new JPanel();
		orderDetailsPanel
				.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_orderDetailsPanel = new GridBagConstraints();
		gbc_orderDetailsPanel.insets = new Insets(5, 5, 5, 5);
		gbc_orderDetailsPanel.fill = GridBagConstraints.BOTH;
		gbc_orderDetailsPanel.gridx = 1;
		gbc_orderDetailsPanel.gridy = 0;
		add(orderDetailsPanel, gbc_orderDetailsPanel);
		GridBagLayout gbl_orderDetailsPanel = new GridBagLayout();
		gbl_orderDetailsPanel.columnWidths = new int[] { 0 };
		gbl_orderDetailsPanel.rowHeights = new int[] { 100, 0 };
		gbl_orderDetailsPanel.columnWeights = new double[] { 1.0 };
		gbl_orderDetailsPanel.rowWeights = new double[] { 0.0, 1.0 };
		orderDetailsPanel.setLayout(gbl_orderDetailsPanel);

		JPanel orderDetailsHeader = new JPanel();
		GridBagConstraints gbc_orderDetailsHeader = new GridBagConstraints();
		gbc_orderDetailsHeader.insets = new Insets(5, 5, 5, 0);
		gbc_orderDetailsHeader.anchor = GridBagConstraints.NORTHWEST;
		gbc_orderDetailsHeader.gridx = 0;
		gbc_orderDetailsHeader.gridy = 0;
		orderDetailsPanel.add(orderDetailsHeader, gbc_orderDetailsHeader);
		GridBagLayout gbl_orderDetailsHeader = new GridBagLayout();
		gbl_orderDetailsHeader.columnWidths = new int[] { 0, 0 };
		gbl_orderDetailsHeader.rowHeights = new int[] { 14, 0, 0, 0, 0 };
		gbl_orderDetailsHeader.columnWeights = new double[] { 0.0, 0.0 };
		gbl_orderDetailsHeader.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		orderDetailsHeader.setLayout(gbl_orderDetailsHeader);

		JLabel lblOrderNumber = new JLabel("Order Number:");
		GridBagConstraints gbc_lblOrderNumber = new GridBagConstraints();
		gbc_lblOrderNumber.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblOrderNumber.insets = new Insets(5, 5, 5, 5);
		gbc_lblOrderNumber.gridx = 0;
		gbc_lblOrderNumber.gridy = 0;
		orderDetailsHeader.add(lblOrderNumber, gbc_lblOrderNumber);

		orderNumberLabel = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(5, 5, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		orderDetailsHeader.add(orderNumberLabel, gbc_label);

		JLabel lblPrice = new JLabel("Price:");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblPrice.insets = new Insets(5, 5, 5, 5);
		gbc_lblPrice.gridx = 0;
		gbc_lblPrice.gridy = 1;
		orderDetailsHeader.add(lblPrice, gbc_lblPrice);

		orderPriceLabel = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(5, 5, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 1;
		orderDetailsHeader.add(orderPriceLabel, gbc_label_1);

		JLabel lblDate = new JLabel("Date:");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDate.insets = new Insets(5, 5, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 2;
		orderDetailsHeader.add(lblDate, gbc_lblDate);

		orderDateLabel = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(5, 5, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 2;
		orderDetailsHeader.add(orderDateLabel, gbc_label_2);

		JLabel lblState = new JLabel("State:");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblState.insets = new Insets(5, 5, 5, 5);
		gbc_lblState.gridx = 0;
		gbc_lblState.gridy = 3;
		orderDetailsHeader.add(lblState, gbc_lblState);

		orderStateLabel = new JLabel("");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(5, 5, 5, 5);
		gbc_label_3.gridx = 1;
		gbc_label_3.gridy = 3;
		orderDetailsHeader.add(orderStateLabel, gbc_label_3);

		orderItemsPanel = createOrderItemsPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 5, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		orderDetailsPanel.add(orderItemsPanel, gbc_panel);

		JPanel orders = new JPanel();
		orders.setBorder(new TitledBorder(null, "Orders", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_orders = new GridBagConstraints();
		gbc_orders.insets = new Insets(5, 5, 5, 5);
		gbc_orders.fill = GridBagConstraints.BOTH;
		gbc_orders.gridx = 0;
		gbc_orders.gridy = 0;
		add(orders, gbc_orders);
		GridBagLayout gbl_orders = new GridBagLayout();
		gbl_orders.columnWidths = new int[] { 0 };
		gbl_orders.rowHeights = new int[] { 0 };
		gbl_orders.columnWeights = new double[] { 1.0 };
		gbl_orders.rowWeights = new double[] { 1.0 };
		orders.setLayout(gbl_orders);

		orderList = new JList<>();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 0;
		orders.add(orderList, gbc_list);
	}
	
	protected JPanel createOrderItemsPanel() {
		return new OrderItemsPanelBase();
	}
}

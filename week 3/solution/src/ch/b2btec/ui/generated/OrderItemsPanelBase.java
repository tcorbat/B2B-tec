package ch.b2btec.ui.generated;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class OrderItemsPanelBase extends JPanel {

	private static final long serialVersionUID = 3609347591388508233L;

	public OrderItemsPanelBase() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Shopping Cart",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		JTable orderItemsTable = new JTable();
		JScrollPane scrollPane = new JScrollPane(orderItemsTable);
		orderItemsTable.setFillsViewportHeight(true);
		add(scrollPane);
	}
}

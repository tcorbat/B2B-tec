package ch.b2btec.ui.generated;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ch.b2btec.ui.models.OrderPositionTableModel;

public class OrderItemsPanelBase extends JPanel {
	protected static final DefaultTableModel DEFAULT_TABLE_MODEL = new DefaultTableModel(new Object[][] {},
			new String[] { "Name", "Number", "Quantity", "Price Each", "Price Total" });

	private static final long serialVersionUID = 3609347591388508233L;
	private final JTable table;

	public OrderItemsPanelBase() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Shopping Cart",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		add(scrollPane);
	}

	public void setTableModel(OrderPositionTableModel orderPositionTableModel) {
		table.setModel(orderPositionTableModel);
		table.setEnabled(true);
	}

	public void clearTableModel() {
		table.setEnabled(false);
		table.setModel(DEFAULT_TABLE_MODEL);
	}
}

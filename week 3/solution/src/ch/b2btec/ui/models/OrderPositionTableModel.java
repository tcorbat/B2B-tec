package ch.b2btec.ui.models;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.domain.ShoppingCart;

public class OrderPositionTableModel implements TableModel {

	private final static String[] TABLE_COLUMN_NAMES = new String[] { "Name", "Number", "Quantity", "Price Each",
			"Price Total" };
	private final static Class<?>[] TABLE_CLASSES = new Class[] { String.class, Integer.class, Integer.class,
			Integer.class, Integer.class };

	private final ShoppingCart cart;

	public OrderPositionTableModel(ShoppingCart cart) {
		this.cart = cart;
	}

	@Override
	public int getRowCount() {
		return cart.getPositions().size();
	}

	@Override
	public int getColumnCount() {
		return TABLE_COLUMN_NAMES.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return TABLE_COLUMN_NAMES[columnIndex];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return TABLE_CLASSES[columnIndex];
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		var orderPosition = cart.getPositions().get(rowIndex);
		Product product = orderPosition.getProduct();
		switch (columnIndex) {
		case 0:
			return product.getName();
		case 1:
			return product.getProductNumber();
		case 2:
			return orderPosition.getQuantity();
		case 3:
			return product.getPrice();
		case 4:
			return orderPosition.getQuantity() * product.getPrice();
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

}

package ch.b2btec.ui.models;

import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.domain.ShoppingCart;

//TODO: Observer Pattern, step 1.1
public class OrderPositionTableModel implements TableModel { //TODO: Observer Pattern, step 1.3

	private final static String[] TABLE_COLUMN_NAMES = new String[] { "Name", "Number", "Quantity", "Price Each",
			"Price Total" };
	private final static Class<?>[] TABLE_CLASSES = new Class[] { String.class, Integer.class, Integer.class,
			Integer.class, Integer.class };

	private final ShoppingCart cart;
	private final ArrayList<TableModelListener> listeners = new ArrayList<>();
	
	public OrderPositionTableModel(ShoppingCart cart) {
		this.cart = cart;

		//TODO: Observer Pattern, step 1.5
		// -- HINT: register observer and forward event to cartUpdated() method
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
		listeners.add(l);
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}
	
	private void cartUpdated() {
		listeners.stream().forEach(listener -> listener.tableChanged(new TableModelEvent(this)));
	}

}

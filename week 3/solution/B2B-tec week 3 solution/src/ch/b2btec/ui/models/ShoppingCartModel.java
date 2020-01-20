package ch.b2btec.ui.models;

import java.beans.PropertyChangeEvent;

import ch.b2btec.bl.domain.ShoppingCart;
import ch.b2btec.utils.PropertyObservable;

public class ShoppingCartModel extends PropertyObservable {
	public enum Property {
		TotalPrice, TotalNumberOfItems
	}

	private final ShoppingCart cart;

	public ShoppingCartModel(ShoppingCart cart) {
		this.cart = cart;
		cart.addPropertyChangeListener(this::shoppingCartChanged);
	}

	// Duplication with OrdersPanel
	public int getTotalPrice() {
		return cart.getPositions().stream()
				.mapToInt(position -> position.getQuantity() * position.getProduct().getPrice()).sum();
	}

	public int getTotalNumberOfItems() {
		return cart.getPositions().stream().mapToInt(position -> position.getQuantity()).sum();
	}
	
	private void shoppingCartChanged(PropertyChangeEvent event) {
		observable.firePropertyChange(Property.TotalPrice.toString(), 0, getTotalPrice());
		observable.firePropertyChange(Property.TotalNumberOfItems.toString(), 0, getTotalNumberOfItems());
	}
}

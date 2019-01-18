package ch.b2btec.ui.models;

import ch.b2btec.bl.domain.ShoppingCart;
import ch.b2btec.utils.PropertyObservable;

public class ShoppingCartModel extends PropertyObservable {
	public enum Property {
		TotalPrice, TotalNumberOfItems
	}

	private final ShoppingCart cart;

	public ShoppingCartModel(ShoppingCart cart) {
		this.cart = cart;
	}

	public int getTotalPrice() {
		return cart.getPositions().stream()
				.mapToInt(position -> position.getQuantity() * position.getProduct().getPrice()).sum();
	}

	public int getTotalNumberOfItems() {
		return cart.getPositions().stream().mapToInt(position -> position.getQuantity()).sum();
	}
}

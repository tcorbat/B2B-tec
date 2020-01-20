package ch.b2btec.ui.models;



import ch.b2btec.bl.domain.ShoppingCart;
import ch.b2btec.utils.CartObserver;
import ch.b2btec.utils.PropertyObservable;

//TODO: Observer Pattern, step 1.1
public class ShoppingCartModel extends PropertyObservable implements CartObserver { // TODO: Observer Pattern, step 1.3
	public enum Property {
		TotalPrice, TotalNumberOfItems
	}

	private final ShoppingCart cart;

	public ShoppingCartModel(ShoppingCart cart) {
		this.cart = cart;
		//TODO: Observer Pattern, step 1.5
		// -- HINT: register observer and ...
		cart.attachObserver(this);
	}

	// TODO: Observer Pattern, step 1.5
	// -- HINT: register observer and forward event to shoppingCartChanged() method
	public void update() {
		shoppingCartChanged();
	}


	// Duplication with OrdersPanel
	public int getTotalPrice() {
		return cart.getPositions().stream()
				.mapToInt(position -> position.getQuantity() * position.getProduct().getPrice()).sum();
	}

	public int getTotalNumberOfItems() {
		return cart.getPositions().stream().mapToInt(position -> position.getQuantity()).sum();
	}
	
	private void shoppingCartChanged() {
		observable.firePropertyChange(Property.TotalPrice.toString(), 0, getTotalPrice());
		observable.firePropertyChange(Property.TotalNumberOfItems.toString(), 0, getTotalNumberOfItems());
	}
}

package ch.b2btec.bl.models.tests;

import java.beans.PropertyChangeListener;

import ch.b2btec.bl.domain.ShoppingCart;

public class ShoppingCartSpy extends ShoppingCart {

	public PropertyChangeListener[] getRegisteredListeners() {
		return observable.getPropertyChangeListeners();
	}

}

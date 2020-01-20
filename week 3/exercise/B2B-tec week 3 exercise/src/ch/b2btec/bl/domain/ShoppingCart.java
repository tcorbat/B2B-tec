package ch.b2btec.bl.domain;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ch.b2btec.utils.PropertyObservable;

//TODO: Observer Pattern, step 1.1
public class ShoppingCart { //TODO: Observer Pattern, step 1.3

	//TODO: 2.3 extend ShoppingCart from ch.b2btec.utils.PropertyObservable, or use:
	// -- protected final PropertyChangeSupport observable = new PropertyChangeSupport(this);
	// -- implement addPropertyChangeListener / removePropertyChangeListener 
	
	public enum Property {
		POSITIONS
	}
	
	//TODO: Observer Pattern, step 1.4
	// -- HINT: list of observers
	
	private final ArrayList<OrderPosition> positions = new ArrayList<>();

	public List<OrderPosition> getPositions() {
		return Collections.unmodifiableList(positions);
	}

	//TODO: Observer Pattern, step 1.4
	// -- HINT: notifyObservers() method, which calls all observers update() methods 
	// -- HINT: attachObserver() method
	
	public void addProduct(Product product) {
		checkNotNull(product);
		var position = findPosition(product);
		if (position.isPresent()) {
			OrderPosition changedPosition = position.get();
			changedPosition.incrementQuantity();
			//TODO: Observer Pattern, step 1.6
			// -- HINT: call notifyObservers() method
			
			//TODO: Observer Pattern, step 2.2
			// -- HINT: when using java.beans.*, use fireIndexedPropertyChange() method
			// --  changed property: Property.POSITIONS.toString()
			// --  changed value/index: positions.indexOf(changedPosition)
			// --  changed old value: null
			// --  changed new value: changedPosition
		} else {
			var newPosition = new OrderPosition(product, 1);
			positions.add(newPosition);
			//TODO: Observer Pattern, step 1.6
			// -- HINT: call notifyObservers() method
			
			//TODO: Observer Pattern, step 2.2
			// -- HINT: when using java.beans.*, use fireIndexedPropertyChange() method
			// --  changed property: Property.POSITIONS.toString()
			// --  changed value/index: positions.size() - 1
			// --  changed old value: null
			// --  changed new value: newPosition
		}
	}

	private Optional<OrderPosition> findPosition(Product product) {
		var productNumber = product.getProductNumber();
		return positions.stream().filter(position -> position.getProduct().getProductNumber() == productNumber)
				.findFirst();
	}

	private static void checkNotNull(Product product) {
		if (product == null) {
			throw new IllegalArgumentException("Product must not be null");
		}
	}
}

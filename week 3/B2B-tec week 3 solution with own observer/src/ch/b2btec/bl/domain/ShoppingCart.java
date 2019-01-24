package ch.b2btec.bl.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ch.b2btec.utils.CartObserver;

//TODO: Observer Pattern, step 1.1
public class ShoppingCart { // TODO: Observer Pattern, step 1.3

	public enum Property {
		POSITIONS
	}
	
	//TODO: Observer Pattern, step 1.4
	// -- HINT: list of observers
	private final List<CartObserver> observers = new ArrayList<>();
	
	private final ArrayList<OrderPosition> positions = new ArrayList<>();

	public List<OrderPosition> getPositions() {
		return Collections.unmodifiableList(positions);
	}

	//TODO: Observer Pattern, step 1.4
	// -- HINT: notifyObservers() method, which calls all observers update() methods 
	// -- HINT: attachObserver() method
	public void attachObserver(CartObserver observer) {
		observers.add(observer);
	}

	public void removeObserver(CartObserver observer) {
		observers.remove(observer);
	}

	protected void notifyObservers() {
		observers.stream().forEach(CartObserver::update);
	}
	
	public void addProduct(Product product) {
		checkNotNull(product);
		var position = findPosition(product);
		if (position.isPresent()) {
			OrderPosition changedPosition = position.get();
			changedPosition.incrementQuantity();
		} else {
			var newPosition = new OrderPosition(product, 1);
			positions.add(newPosition);
		}
		// TODO: Observer Pattern, step 1.6
		// -- HINT: call notifyObservers() method
		notifyObservers();
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

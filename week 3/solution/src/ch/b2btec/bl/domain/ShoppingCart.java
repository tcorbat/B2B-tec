package ch.b2btec.bl.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ch.b2btec.utils.PropertyObservable;

public class ShoppingCart extends PropertyObservable {
	public enum Property {
		POSITIONS
	}
	private final ArrayList<OrderPosition> positions = new ArrayList<>();

	public List<OrderPosition> getPositions() {
		return Collections.unmodifiableList(positions);
	}

	public void addProduct(Product product) {
		checkNotNull(product);
		var position = findPosition(product);
		if (position.isPresent()) {
			OrderPosition changedPosition = position.get();
			changedPosition.incrementQuantity();
			observable.fireIndexedPropertyChange(Property.POSITIONS.toString(), positions.indexOf(changedPosition), null,
					changedPosition);
		} else {
			var newPosition = new OrderPosition(product, 1);
			positions.add(newPosition);
			observable.fireIndexedPropertyChange(Property.POSITIONS.toString(), positions.size() - 1, null,
					newPosition);
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

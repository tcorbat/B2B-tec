package ch.b2btec.bl.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {
	private final ArrayList<OrderPosition> positions = new ArrayList<>();

	public List<OrderPosition> getPositions() {
		return Collections.unmodifiableList(positions);
	}

	public void addProduct(Product product) {
		checkNotNull(product);
		var position = findPosition(product);
		if (position.isPresent()) {
			position.get().incrementQuantity();
		} else {
			positions.add(new OrderPosition(product, 1));
		}
	}

	public int getTotalPrice() {
		return positions.stream().mapToInt(position -> position.getProduct().getPrice() * position.getQuantity()).sum();
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

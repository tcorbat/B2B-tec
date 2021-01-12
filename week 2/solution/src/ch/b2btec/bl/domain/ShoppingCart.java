package ch.b2btec.bl.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ch.b2btec.bl.Price;

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

	public Price getTotalPrice() {
		return positions.stream().map(position -> position.getProduct().getPrice().multiply(position.getQuantity()))
				.reduce((lhs, rhs) -> lhs.add(rhs)).orElse(new Price());
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

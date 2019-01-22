package ch.b2btec.bl.domain;

import ch.b2btec.bl.exceptions.QuantityMustBePositiveException;

public class OrderPosition {
	private final Product product;
	private int quantity;

	public OrderPosition(Product product, int quantity) {
		checkNotNull(product);
		this.product = product;
		this.setQuantity(quantity);
	}

	public void incrementQuantity() {
		quantity++;
	}

	public void decrementQuantity() {
		checkQuantity(quantity - 1);
		quantity--;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		checkQuantity(quantity);
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	private static void checkQuantity(int quantity) {
		if (quantity < 0) {
			throw new QuantityMustBePositiveException(quantity);
		}
	}

	private static void checkNotNull(Product product) {
		if (product == null) {
			throw new IllegalArgumentException("Product must not be null");
		}
	}
}

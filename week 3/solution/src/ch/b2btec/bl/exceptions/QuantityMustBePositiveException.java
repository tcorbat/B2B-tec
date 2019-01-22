package ch.b2btec.bl.exceptions;

public class QuantityMustBePositiveException extends RuntimeException {
	private static final long serialVersionUID = -5464355472143207571L;

	public QuantityMustBePositiveException(int actualQuantity) {
		super("Quantity must be positive, but was: " + actualQuantity);
	}
}

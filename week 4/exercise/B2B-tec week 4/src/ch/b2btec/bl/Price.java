package ch.b2btec.bl;

import java.util.Currency;

public class Price {
	//TODO: Add fields for amount and currency, make them final
	
	public Price() {
		//TODO: Implement
	}

	public Price(long amount) {
		//TODO: Implement
	}

	public Price(long amount, Currency currency) {
		//TODO: Implement
	}

	public Price add(Price other) {
		//TODO: Implement
		return this;
	}

	public Price multiply(double factor) {
		//TODO: Implement
		return this;
	}

	@Override
	public String toString() {
		//TODO: Implement
		return super.toString();
	}

	@Override
	public boolean equals(Object other) {
		//TODO: Implement
		return super.equals(other);
	}

	@Override
	public int hashCode() {
		//TODO: Implement
		return super.hashCode();
	}
}

package ch.b2btec.bl;

import java.util.Currency;
import java.util.Objects;

public class Price {
	private final long amount;
	private final Currency currency;

	public Price() {
		this(0);
	}

	public Price(long amount) {
		this(amount, Currency.getInstance("CHF"));
	}

	public Price(long amount, Currency currency) {
		if (amount < 0) {
			throw new IllegalArgumentException("A price cannot be negative");
		}
		this.amount = amount;
		this.currency = currency;
	}

	public Price add(Price other) {
		if (!currency.equals(other.currency)) {
			throw new IllegalArgumentException("Cannot add different currencies");
		}
		return new Price(amount + other.amount, currency);
	}

	public Price multiply(double factor) {
		return new Price(Math.round(amount * factor), currency);
	}

	@Override
	public String toString() {
		var fractionDigits = currency.getDefaultFractionDigits();
		var amountString = Long.toString(amount);
		int numberOfDigits = amountString.length();
		if (numberOfDigits > fractionDigits) {
			int fractionStart = numberOfDigits - fractionDigits;
			amountString = amountString.substring(0, fractionStart) + '.' + amountString.substring(fractionStart);
		} else {
			for (int missingZeros = 0; missingZeros < fractionDigits - numberOfDigits; missingZeros++) {
				amountString = '0' + amountString;
			}
			amountString = "0." + amountString;
		}

		return currency.getCurrencyCode() + ' ' + amountString;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, currency);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Price other = (Price) obj;
		return amount == other.amount && Objects.equals(currency, other.currency);
	}
}

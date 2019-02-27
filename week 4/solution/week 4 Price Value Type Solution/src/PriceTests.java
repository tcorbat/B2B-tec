

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Currency;

import org.junit.jupiter.api.Test;


class PriceTests {

	@Test
	void testToStringOfDefaultPrice() {
		var price = new Price();
		assertEquals("CHF 0.00", price.toString());
	}

	@Test
	void testToStringOfOneRappen() {
		var price = new Price(1);
		assertEquals("CHF 0.01", price.toString());
	}

	@Test
	void testToStringOf25Rappen() {
		var price = new Price(25);
		assertEquals("CHF 0.25", price.toString());
	}

	@Test
	void testToStringOfOneFranken() {
		var price = new Price(100);
		assertEquals("CHF 1.00", price.toString());
	}

	@Test
	void testToStringOfManyFranken() {
		var price = new Price(1500000);
		assertEquals("CHF 15000.00", price.toString());
	}

	@Test
	void testToStringOfOneUSDollar() {
		var price = new Price(100, Currency.getInstance("USD"));
		assertEquals("USD 1.00", price.toString());
	}

	@Test
	void testToStringOfOneEuro() {
		var price = new Price(100, Currency.getInstance("EUR"));
		assertEquals("EUR 1.00", price.toString());
	}

	@Test
	void testSamePricesAreEqual() {
		var price1 = new Price(100, Currency.getInstance("USD"));
		var price2 = new Price(100, Currency.getInstance("USD"));
		assertEquals(price1, price2);
	}

	@Test
	void testDifferentPriceAmountsAreNotEqual() {
		var price1 = new Price(101, Currency.getInstance("USD"));
		var price2 = new Price(100, Currency.getInstance("USD"));
		assertNotEquals(price1, price2);
	}

	@Test
	void testDifferentCurrenciesAreNotEqual() {
		var price1 = new Price(100, Currency.getInstance("USD"));
		var price2 = new Price(100, Currency.getInstance("EUR"));
		assertNotEquals(price1, price2);
	}

	@Test
	void testAddTwoPrices() {
		var expected = new Price(579, Currency.getInstance("USD"));
		var price1 = new Price(456, Currency.getInstance("USD"));
		var price2 = new Price(123, Currency.getInstance("USD"));
		assertEquals(expected, price1.add(price2));
	}

	@Test
	void testAddDifferentCurrenciesThrows() {
		var price1 = new Price(456, Currency.getInstance("USD"));
		var price2 = new Price(123, Currency.getInstance("EUR"));
		assertThrows(IllegalArgumentException.class, () -> price1.add(price2));
	}

	@Test
	void testCannotCreateNegativePrice() {
		assertThrows(IllegalArgumentException.class, () -> new Price(-456, Currency.getInstance("USD")));
	}

	@Test
	void testMultiplyAPrice() {
		var expected = new Price(1845, Currency.getInstance("EUR"));
		var price = new Price(123, Currency.getInstance("EUR"));
		assertEquals(expected, price.multiply(15.0));
	}

	@Test
	void testReduceAPrice() {
		var expected = new Price(40, Currency.getInstance("EUR"));
		var price = new Price(400, Currency.getInstance("EUR"));
		assertEquals(expected, price.multiply(0.1));
	}

	@Test
	void testMultiplyRounds() {
		var expected = new Price(66, Currency.getInstance("EUR"));
		var price = new Price(131, Currency.getInstance("EUR"));
		assertEquals(expected, price.multiply(0.5));
	}

	@Test
	void testMultiplyWithNegtiveThrows() {
		var price = new Price(131, Currency.getInstance("EUR"));
		assertThrows(IllegalArgumentException.class, () -> price.multiply(-1.0));
	}

	@Test
	void testSamePricesHaveTheSameHashCode() {
		var price1 = new Price(100, Currency.getInstance("USD"));
		var price2 = new Price(100, Currency.getInstance("USD"));
		assertEquals(price1.hashCode(), price2.hashCode());
	}

	@Test
	void testDifferentPriceAmountsHaveDifferentHashCode() {
		var price1 = new Price(101, Currency.getInstance("USD"));
		var price2 = new Price(100, Currency.getInstance("USD"));
		assertNotEquals(price1.hashCode(), price2.hashCode());
	}

	@Test
	void testDifferentCurrenciesHaveDifferentHashCode() {
		var price1 = new Price(100, Currency.getInstance("USD"));
		var price2 = new Price(100, Currency.getInstance("EUR"));
		assertNotEquals(price1.hashCode(), price2.hashCode());
	}
}

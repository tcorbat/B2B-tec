package ch.b2btec.bl.models.tests;

import ch.b2btec.bl.Price;
import ch.b2btec.bl.domain.Product;

public class TestProductFactory {
	private static int nextTestItemNumber = 1;

	public static Product createTestItem(int price) {
		var productName = String.format("Test Item {0}", nextTestItemNumber);
		return new Product(nextTestItemNumber++, productName, new Price(price), "", "");
	}
}

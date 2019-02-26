package catalog;

import java.io.PrintStream;

public class GiftCoupon implements CatalogItem {
	private static final String COUPON = "Coupon";
	private final int price;

	public GiftCoupon(int price) {
		this.price = price;
	}

	@Override
	public String getName() {
		return COUPON;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public void display(PrintStream stream) {
		stream.println("Coupon for $" + price);
	}

}

package catalog;

import catalog.visitor.CatalogItemVisitor;

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
	public void accept(CatalogItemVisitor visitor) {
		visitor.visit(this);
	}

}

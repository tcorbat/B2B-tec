package catalog.visitor;

import catalog.Category;
import catalog.GiftCoupon;
import catalog.Product;
import catalog.Service;

public class CatalogItemVisitorBase implements CatalogItemVisitor {

	@Override
	public void visit(Category category) {
	}

	@Override
	public void visit(GiftCoupon coupon) {
	}

	@Override
	public void visit(Product product) {
	}

	@Override
	public void visit(Service service) {
	}

}

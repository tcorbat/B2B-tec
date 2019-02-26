package catalog.visitor;

import catalog.Category;
import catalog.GiftCoupon;
import catalog.Product;
import catalog.Service;

public interface CatalogItemVisitor {
	public void visit(Category category);

	public void visit(GiftCoupon coupon);

	public void visit(Product product);

	public void visit(Service service);
}

package catalog.visitor;

import java.io.PrintStream;

import catalog.Category;
import catalog.GiftCoupon;
import catalog.Product;
import catalog.Service;

public class CatalogItemDisplayVisitor extends CatalogItemVisitorBase {
	private final PrintStream stream;

	public CatalogItemDisplayVisitor(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void visit(Category category) {
		stream.println("Category: " + category.getName());
	}

	@Override
	public void visit(GiftCoupon coupon) {
		stream.println("Coupon for $" + coupon.getPrice());
	}

	@Override
	public void visit(Product product) {
		stream.println("Product: " + product.getName() + " costs $" + product.getPrice());
	}

	@Override
	public void visit(Service service) {
		stream.println("Service: " + service.getName() + " costs $" + service.getPrice());
	}
}

package application;

import java.util.ArrayList;

import catalog.CatalogItem;
import catalog.Category;
import catalog.GiftCoupon;
import catalog.Product;
import catalog.Service;
import catalog.visitor.CatalogItemDisplayVisitor;

public class CompositeExample {

	public static void main(String[] args) {
		var catalog = createCatalog();
		var visitor = new CatalogItemDisplayVisitor(System.out);
		catalog.forEach(item -> item.accept(visitor));
	}

	private static ArrayList<CatalogItem> createCatalog() {
		var catalog = new ArrayList<CatalogItem>();
		var cars = new Category("Cars");
		cars.addItem(new Product("Mitsubishi Colt", 10000, "It's a car", null));
		cars.addItem(new Product("Tesla Model 3", 60000, "It's an electric car", null));
		cars.addItem(new Product("Toyota Mirai", 90000, "It's a hydrogen car", null));
		catalog.add(cars);
		var services = new Category("Services");
		var cleaning = new Category("Cleaning");
		services.addItem(cleaning);
		services.addItem(new Service("Change Oil", 150, "Put some grease on the motor"));
		cleaning.addItem(new Service("Wash Exterior", 20, "Splash some water onto the windshield"));
		cleaning.addItem(new Service("Vacuum Iterior", 30, "Clean car interior"));
		catalog.add(services);
		catalog.add(new GiftCoupon(50));
		catalog.add(new GiftCoupon(100));
		catalog.add(new GiftCoupon(200));
		return catalog;
	}

}

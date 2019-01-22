import java.io.File;
import java.io.FileWriter;

import com.google.gson.GsonBuilder;

import ch.b2btec.bl.domain.Catalog;
import ch.b2btec.bl.domain.Category;
import ch.b2btec.bl.domain.Product;

public class HardcodedCatalogBuilder {

	private final static Catalog CATALOG = new Catalog();
	private static int nextProductNumber = 1;
	
	private static Category addCategory(String name) {
		return addCategory(name, null);
	}
	
	private static Category addCategory(String name, Category parentCategory) {
		var category = new Category(name, parentCategory);
		CATALOG.addCategory(category);
		return category;
	}
	
	private static Product createProduct(String name, int price, String description, String specification) {
		return new Product(nextProductNumber++, name, price, description, specification);
	}
	
	public static void main(String[] args) throws Exception {
		var items = addCategory("Items");
		var containers = addCategory("Containers", items);
		var mugs = addCategory("Mugs", containers);
		var bottles = addCategory("Bottles", containers);
		var crockery = addCategory("Crockery", items);
		var cutlery = addCategory("Cutlery", items);
		
		containers.addProduct(createProduct("Wooden Box", 20, "Holds some items", "30x20x15cm"));
		
		mugs.addProduct(createProduct("Espresso Cup", 15, "Holds a little coffee", "Volume 0.5dl"));
		mugs.addProduct(createProduct("Small Coffee Mug", 9, "Holds some coffee, or tea", "Volume 2dl"));
		mugs.addProduct(createProduct("Medium Coffee Mug", 12, "Holds a little more coffee, or tea", "Volume 3dl"));
		mugs.addProduct(createProduct("Large Coffee Mug", 15, "Holds much coffee, or tea", "Volume 5dl"));
		mugs.addProduct(createProduct("Huge Coffee Mug", 18, "Holds too much coffee, or tea", "Volume 7dl"));
		
		bottles.addProduct(createProduct("Small Bottle", 5, "Exquisitly designed water bottle", "Volume 3dl"));
		bottles.addProduct(createProduct("Medium Bottle", 1, "Profane water bottle", "Volume 5dl"));
		bottles.addProduct(createProduct("Large Bottle", 2, "Profane water bottle", "Volume 1l"));
		bottles.addProduct(createProduct("Extra Large Bottle", 3, "Profane water bottle", "Volume 1.5l"));
		bottles.addProduct(createProduct("Double Extra Large Bottle", 6, "Profane water bottle", "Volume 2l"));
		
		crockery.addProduct(createProduct("Saucer", 8, "Holds a Small Coffe Mug", "White with blue border, diameter 10cm"));
		crockery.addProduct(createProduct("Small Plate", 10, "Breakfast plate", "White with blue border, diameter 18cm"));
		crockery.addProduct(createProduct("Normal Plate", 12, "Dinner plate", "White with blue border, diameter 25cm"));
		
		cutlery.addProduct(createProduct("Knife", 3, "Cuts food", "Stainless steel"));
		cutlery.addProduct(createProduct("Fork", 3, "Stabs food", "Stainless steel"));
		cutlery.addProduct(createProduct("Teaspoon", 2, "Stirrs tea", "Stainless steel"));
		cutlery.addProduct(createProduct("Spoon", 3, "Scoops food", "Stainless steel"));
		
		var builder = new GsonBuilder();
		builder.serializeNulls();
		builder.setPrettyPrinting();
		var gson = builder.create();
		System.out.println(gson.toJson(CATALOG));
		var catalogFile = new File("catalog.json");
		try (var writer = new FileWriter(catalogFile)) {
			writer.write(gson.toJson(CATALOG));
		}
	}

}
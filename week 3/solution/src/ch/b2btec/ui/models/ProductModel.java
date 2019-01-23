package ch.b2btec.ui.models;

import ch.b2btec.bl.domain.Product;
import ch.b2btec.utils.PropertyObservable;

public class ProductModel extends PropertyObservable {

	public static enum Property {
		Name, Number, Price, Description, Specification
	}

	private String name;
	private String price;
	private String number;
	private String description;
	private String specification;

	public void showProduct(Product product) {
		setName(product.getName());
		setPrice(Integer.toString(product.getPrice()));
		setNumber(Integer.toString(product.getProductNumber()));
		setDescription(product.getDescription());
		setSpecification(product.getSpecification());
	}

	public void clear() {
		setName("");
		setPrice("");
		setNumber("");
		setDescription("");
		setSpecification("");
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		var oldValue = this.name;
		this.name = name;
		observable.firePropertyChange(Property.Name.toString(), oldValue, name);
	}

	public String getPrice() {
		return price;
	}

	private void setPrice(String price) {
		String oldValue = this.price;
		this.price = price;
		observable.firePropertyChange(Property.Price.toString(), oldValue, price);
	}

	public String getNumber() {
		return number;
	}

	private void setNumber(String number) {
		var oldValue = this.number;
		this.number = number;
		observable.firePropertyChange(Property.Number.toString(), oldValue, number);
	}

	public String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		var oldValue = this.description;
		this.description = description;
		observable.firePropertyChange(Property.Description.toString(), oldValue, description);
	}

	public String getSpecification() {
		return specification;
	}

	private void setSpecification(String specification) {
		var oldValue = this.specification;
		this.specification = specification;
		observable.firePropertyChange(Property.Specification.toString(), oldValue, specification);
	}
}

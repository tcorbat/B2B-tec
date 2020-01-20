package ch.b2btec.ui.models;

import java.util.Optional;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Product;
import ch.b2btec.bl.services.OrderManagement;
import ch.b2btec.utils.PropertyObservable;

public class ShopModel extends PropertyObservable {

	public static enum Property {
		ProductSelected
	}
	
	private final ProductModel productDetailModel = new ProductModel();
	private final Customer customer;
	private final OrderManagement orderManagement;
	private Optional<Product> selectedProduct;

	public ShopModel(Customer customer, OrderManagement orderManagement) {
		this.customer = customer;
		this.orderManagement = orderManagement;
	}

	public ProductModel getProductDetailModel() {
		return productDetailModel;
	}

	public void showProduct(Product product) {
		productDetailModel.show(product);
		setSelectedProduct(Optional.of(product));
	}

	public void clearProduct() {
		setSelectedProduct(Optional.empty());
		productDetailModel.clear();
	}
	
	public void addSelectedProductToCart() {
		var customersOrders = orderManagement.getOrders(customer);
		var firstOrder = customersOrders.get(0);
		selectedProduct.ifPresent(product -> firstOrder.getCart().addProduct(product));
	}
	
	public boolean isAddToCartEnabled() {
		return selectedProduct.isPresent();
	}
	
	public void setSelectedProduct(Optional<Product> selectedProduct) {
		var oldValue = this.selectedProduct;
		this.selectedProduct = selectedProduct;
		observable.firePropertyChange(Property.ProductSelected.toString(), oldValue, selectedProduct);
	}

}

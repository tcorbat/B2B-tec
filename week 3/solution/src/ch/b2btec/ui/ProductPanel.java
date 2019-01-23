package ch.b2btec.ui;

import java.beans.PropertyChangeEvent;

import ch.b2btec.ui.generated.ProductPanelBase;
import ch.b2btec.ui.models.ProductModel;
import ch.b2btec.ui.models.ProductModel.Property;

public class ProductPanel extends ProductPanelBase {
	private static final long serialVersionUID = 7250649779479486522L;

	private final ProductModel productPanelModel;

	public ProductPanel(ProductModel productPanelModel) {
		this.productPanelModel = productPanelModel;
		productPanelModel.addPropertyChangeListener(this::modelChanged);
	}

	private void modelChanged(PropertyChangeEvent event) {

		Property property = Property.valueOf(event.getPropertyName());
		switch (property) {
		case Name:
			nameLabel.setText(productPanelModel.getName());
			break;
		case Price:
			priceLabel.setText(productPanelModel.getPrice());
			break;
		case Number:
			numberLabel.setText(productPanelModel.getNumber());
			break;
		case Description:
			descriptionPane.setText(productPanelModel.getDescription());
			break;
		case Specification:
			specificationPane.setText(productPanelModel.getSpecification());
			break;
		}
	}
}

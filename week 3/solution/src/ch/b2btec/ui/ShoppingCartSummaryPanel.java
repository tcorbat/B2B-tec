package ch.b2btec.ui;

import ch.b2btec.ui.generated.ShoppingCartSummaryPanelBase;
import ch.b2btec.ui.models.ShoppingCartModel;

public class ShoppingCartSummaryPanel extends ShoppingCartSummaryPanelBase {

	private ShoppingCartModel model;

	public ShoppingCartSummaryPanel(ShoppingCartModel model) {
		this.model = model;
	}

}

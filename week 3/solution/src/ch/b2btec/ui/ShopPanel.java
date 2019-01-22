package ch.b2btec.ui;

import javax.swing.JPanel;

import ch.b2btec.bl.domain.Product;
import ch.b2btec.ui.generated.ShopPanelBase;

public class ShopPanel extends ShopPanelBase<Product> {

	private static final long serialVersionUID = 1562773625035679136L;

	@Override
	protected JPanel createDetailsPanel() {
		return new ProductPanel();
	}
}

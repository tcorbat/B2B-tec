package ch.b2btec.ui.generated;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShoppingCartSummaryPanelBase extends JPanel {

	private static final long serialVersionUID = -1210355492871056351L;
	protected final JLabel itemsInCartLabel;
	protected final JLabel totalPriceLabel;

	public ShoppingCartSummaryPanelBase() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel lblShoppingCart = new JLabel("Items in Cart:");
		GridBagConstraints gbc_lblShoppingCart = new GridBagConstraints();
		gbc_lblShoppingCart.anchor = GridBagConstraints.EAST;
		gbc_lblShoppingCart.insets = new Insets(5, 5, 5, 5);
		gbc_lblShoppingCart.gridx = 0;
		gbc_lblShoppingCart.gridy = 0;
		add(lblShoppingCart, gbc_lblShoppingCart);

		itemsInCartLabel = new JLabel("# Items");
		GridBagConstraints gbc_lblItems = new GridBagConstraints();
		gbc_lblItems.anchor = GridBagConstraints.EAST;
		gbc_lblItems.insets = new Insets(5, 5, 5, 5);
		gbc_lblItems.gridx = 1;
		gbc_lblItems.gridy = 0;
		add(itemsInCartLabel, gbc_lblItems);

		JLabel lblTotalPrice = new JLabel("Total Price:");
		GridBagConstraints gbc_lblTotalPrice = new GridBagConstraints();
		gbc_lblTotalPrice.anchor = GridBagConstraints.EAST;
		gbc_lblTotalPrice.insets = new Insets(5, 5, 5, 5);
		gbc_lblTotalPrice.gridx = 0;
		gbc_lblTotalPrice.gridy = 1;
		add(lblTotalPrice, gbc_lblTotalPrice);

		totalPriceLabel = new JLabel("$ Total");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.insets = new Insets(5, 5, 5, 5);
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 1;
		add(totalPriceLabel, gbc_lblTotal);
	}

}

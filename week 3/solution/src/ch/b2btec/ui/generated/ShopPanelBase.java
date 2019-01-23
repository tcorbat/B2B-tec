package ch.b2btec.ui.generated;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;

public class ShopPanelBase<Customer, Product, OrderManagement, CatalogManagement> extends JPanel {
	private static final long serialVersionUID = 8233584153319109341L;
	private final JPanel shoppingCartPanel;
	protected final JButton addToCartButton;
	
	public ShopPanelBase(Customer customer, OrderManagement orderManagement, CatalogManagement catalogManagement) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 175, 250 };
		gridBagLayout.rowHeights = new int[] { 100, 30, 200 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0 };
		setLayout(gridBagLayout);

		addToCartButton = new JButton("Add to Cart");
		addToCartButton.setEnabled(false);
		GridBagConstraints gbc_btnAddToCart = new GridBagConstraints();
		gbc_btnAddToCart.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddToCart.gridx = 1;
		gbc_btnAddToCart.gridy = 1;
		add(addToCartButton, gbc_btnAddToCart);

		shoppingCartPanel = new JPanel();
		shoppingCartPanel
				.setBorder(new TitledBorder(null, "Shopping Cart", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_productsPanel = new GridBagConstraints();
		gbc_productsPanel.insets = new Insets(5, 5, 0, 0);
		gbc_productsPanel.fill = GridBagConstraints.BOTH;
		gbc_productsPanel.gridx = 1;
		gbc_productsPanel.gridy = 2;
		add(shoppingCartPanel, gbc_productsPanel);
		GridBagLayout gbl_productsPanel = new GridBagLayout();
		gbl_productsPanel.columnWidths = new int[] { 212, 1, 0 };
		gbl_productsPanel.rowHeights = new int[] { 1, 0 };
		gbl_productsPanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_productsPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		shoppingCartPanel.setLayout(gbl_productsPanel);

		JList<Product> list = new JList<>();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.anchor = GridBagConstraints.NORTHWEST;
		gbc_list.gridx = 1;
		gbc_list.gridy = 0;
		shoppingCartPanel.add(list, gbc_list);

		JPanel panel = createDetailsPanel(customer, orderManagement);
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(5, 5, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

		JPanel treePanel = new JPanel();
		treePanel.setBorder(new TitledBorder(null, "Categories", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_treePanel = new GridBagConstraints();
		gbc_treePanel.gridheight = 3;
		gbc_treePanel.insets = new Insets(5, 5, 0, 5);
		gbc_treePanel.fill = GridBagConstraints.BOTH;
		gbc_treePanel.gridx = 0;
		gbc_treePanel.gridy = 0;
		add(treePanel, gbc_treePanel);
		treePanel.setLayout(new GridLayout(0, 1, 0, 0));

		JTree categoryTree = new JTree();
		configureCategoryTree(categoryTree, catalogManagement);
		treePanel.add(categoryTree);
	}

	protected void configureCategoryTree(JTree categoryTree, CatalogManagement catalogManagement) {
	}

	protected JPanel createDetailsPanel(Customer customer, OrderManagement orderManagement) {
		return new ProductPanelBase();
	}
}

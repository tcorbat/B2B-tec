package ch.b2btec.ui.generated;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ProductPanelBase extends JPanel {
	private static final long serialVersionUID = 492610499667037946L;

	protected JLabel nameLabel;
	protected JLabel priceLabel;
	protected JLabel numberLabel;
	protected JTextPane descriptionPane;
	protected JTextPane specificationPane;

	public ProductPanelBase() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 75, 150, 50, 50, 75, 50 };
		gridBagLayout.rowHeights = new int[] { 0, 50, 50 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0 };
		setLayout(gridBagLayout);

		JLabel lblProductName = new JLabel("Product Name:");
		GridBagConstraints gbc_lblProductName = new GridBagConstraints();
		gbc_lblProductName.insets = new Insets(5, 5, 5, 5);
		gbc_lblProductName.gridx = 0;
		gbc_lblProductName.gridy = 0;
		add(lblProductName, gbc_lblProductName);

		nameLabel = new JLabel("<Name>");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(5, 5, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 0;
		add(nameLabel, gbc_label);

		JLabel lblPrice = new JLabel("Price:");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.anchor = GridBagConstraints.EAST;
		gbc_lblPrice.insets = new Insets(5, 5, 5, 5);
		gbc_lblPrice.gridx = 2;
		gbc_lblPrice.gridy = 0;
		add(lblPrice, gbc_lblPrice);

		priceLabel = new JLabel("$");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(5, 5, 5, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 0;
		add(priceLabel, gbc_label_2);

		JLabel lblProductNr = new JLabel("Product Nr.:");
		GridBagConstraints gbc_lblProductNr = new GridBagConstraints();
		gbc_lblProductNr.anchor = GridBagConstraints.EAST;
		gbc_lblProductNr.insets = new Insets(5, 5, 5, 5);
		gbc_lblProductNr.gridx = 4;
		gbc_lblProductNr.gridy = 0;
		add(lblProductNr, gbc_lblProductNr);

		numberLabel = new JLabel("#");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(5, 5, 5, 5);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 0;
		add(numberLabel, gbc_label_1);

		JLabel lblDescription = new JLabel("Description:");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescription.insets = new Insets(5, 5, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		add(lblDescription, gbc_lblDescription);

		descriptionPane = new JTextPane();
		descriptionPane.setEditable(false);
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.insets = new Insets(5, 5, 5, 5);
		gbc_textPane.gridwidth = 5;
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 1;
		gbc_textPane.gridy = 1;
		add(descriptionPane, gbc_textPane);

		JLabel lblSpecification = new JLabel("Specification:");
		GridBagConstraints gbc_lblSpecification = new GridBagConstraints();
		gbc_lblSpecification.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblSpecification.insets = new Insets(5, 5, 5, 5);
		gbc_lblSpecification.gridx = 0;
		gbc_lblSpecification.gridy = 2;
		add(lblSpecification, gbc_lblSpecification);

		specificationPane = new JTextPane();
		specificationPane.setEditable(false);
		GridBagConstraints gbc_textPane_1 = new GridBagConstraints();
		gbc_textPane_1.gridwidth = 5;
		gbc_textPane_1.insets = new Insets(5, 5, 5, 5);
		gbc_textPane_1.fill = GridBagConstraints.BOTH;
		gbc_textPane_1.gridx = 1;
		gbc_textPane_1.gridy = 2;
		add(specificationPane, gbc_textPane_1);
	}

}

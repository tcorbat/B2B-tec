package ch.b2btec.ui.generated;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddressPanelBase extends JPanel {
	private static final long serialVersionUID = -5008790770625987927L;

	protected JTextField streetField;
	protected JFormattedTextField houseNumberField;
	protected JFormattedTextField zipCodeField;
	protected JTextField cityField;
	protected JTextField countryField;
	protected JLabel messageLabel;

	public AddressPanelBase() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 0, 30 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 30 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		setLayout(gridBagLayout);

		JLabel lblStreet = new JLabel("Street:");
		GridBagConstraints gbc_lblStreet = new GridBagConstraints();
		gbc_lblStreet.anchor = GridBagConstraints.EAST;
		gbc_lblStreet.insets = new Insets(5, 5, 5, 5);
		gbc_lblStreet.gridx = 0;
		gbc_lblStreet.gridy = 0;
		add(lblStreet, gbc_lblStreet);

		streetField = new JTextField();
		GridBagConstraints gbc_streetField = new GridBagConstraints();
		gbc_streetField.insets = new Insets(5, 0, 5, 5);
		gbc_streetField.fill = GridBagConstraints.HORIZONTAL;
		gbc_streetField.gridx = 1;
		gbc_streetField.gridy = 0;
		add(streetField, gbc_streetField);
		streetField.setColumns(10);

		JLabel lblHouseNumber = new JLabel("House Number:");
		GridBagConstraints gbc_lblHouseNumber = new GridBagConstraints();
		gbc_lblHouseNumber.anchor = GridBagConstraints.EAST;
		gbc_lblHouseNumber.insets = new Insets(5, 5, 5, 5);
		gbc_lblHouseNumber.gridx = 0;
		gbc_lblHouseNumber.gridy = 1;
		add(lblHouseNumber, gbc_lblHouseNumber);

		houseNumberField = new JFormattedTextField();
		GridBagConstraints gbc_houseNumberField = new GridBagConstraints();
		gbc_houseNumberField.anchor = GridBagConstraints.WEST;
		gbc_houseNumberField.insets = new Insets(5, 0, 5, 5);
		gbc_houseNumberField.gridx = 1;
		gbc_houseNumberField.gridy = 1;
		add(houseNumberField, gbc_houseNumberField);
		houseNumberField.setColumns(10);

		JLabel lblZipCode = new JLabel("Zip Code:");
		GridBagConstraints gbc_lblZipCode = new GridBagConstraints();
		gbc_lblZipCode.anchor = GridBagConstraints.EAST;
		gbc_lblZipCode.insets = new Insets(5, 5, 5, 5);
		gbc_lblZipCode.gridx = 0;
		gbc_lblZipCode.gridy = 2;
		add(lblZipCode, gbc_lblZipCode);

		zipCodeField = new JFormattedTextField();
		GridBagConstraints gbc_zipCodeField = new GridBagConstraints();
		gbc_zipCodeField.anchor = GridBagConstraints.WEST;
		gbc_zipCodeField.insets = new Insets(5, 0, 5, 5);
		gbc_zipCodeField.gridx = 1;
		gbc_zipCodeField.gridy = 2;
		add(zipCodeField, gbc_zipCodeField);
		zipCodeField.setColumns(10);

		JLabel lblCity = new JLabel("City:");
		GridBagConstraints gbc_lblCity = new GridBagConstraints();
		gbc_lblCity.anchor = GridBagConstraints.EAST;
		gbc_lblCity.insets = new Insets(5, 5, 5, 5);
		gbc_lblCity.gridx = 0;
		gbc_lblCity.gridy = 3;
		add(lblCity, gbc_lblCity);

		cityField = new JTextField();
		GridBagConstraints gbc_cityField = new GridBagConstraints();
		gbc_cityField.insets = new Insets(5, 0, 5, 5);
		gbc_cityField.fill = GridBagConstraints.HORIZONTAL;
		gbc_cityField.gridx = 1;
		gbc_cityField.gridy = 3;
		add(cityField, gbc_cityField);
		cityField.setColumns(10);

		JLabel lblCountry = new JLabel("Country:");
		GridBagConstraints gbc_lblCountry = new GridBagConstraints();
		gbc_lblCountry.anchor = GridBagConstraints.EAST;
		gbc_lblCountry.insets = new Insets(5, 5, 5, 5);
		gbc_lblCountry.gridx = 0;
		gbc_lblCountry.gridy = 4;
		add(lblCountry, gbc_lblCountry);

		countryField = new JTextField();
		GridBagConstraints gbc_countryField = new GridBagConstraints();
		gbc_countryField.insets = new Insets(5, 0, 5, 5);
		gbc_countryField.fill = GridBagConstraints.HORIZONTAL;
		gbc_countryField.gridx = 1;
		gbc_countryField.gridy = 4;
		add(countryField, gbc_countryField);
		countryField.setColumns(10);

		messageLabel = new JLabel("");
		messageLabel.setForeground(Color.RED);
		GridBagConstraints gbc_messageLabel = new GridBagConstraints();
		gbc_messageLabel.gridwidth = 2;
		gbc_messageLabel.insets = new Insets(5, 0, 0, 5);
		gbc_messageLabel.gridx = 0;
		gbc_messageLabel.gridy = 5;
		add(messageLabel, gbc_messageLabel);
	}
}

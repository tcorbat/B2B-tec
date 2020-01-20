package ch.b2btec.ui.generated;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.ui.AddressPanel;
import ch.b2btec.ui.models.AddressModel;

public class ProfileTabBase extends JPanel {
	private static final long serialVersionUID = -3501323630210245255L;

	protected final JLabel customerNameLabel;
	protected final JLabel businessNumberlabel;
	protected final JButton changePasswordButton;

	protected ProfileTabBase(Customer customer) {
		JPanel userPanel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {0, 0, 0};
		gbl_panel.rowHeights = new int[]{55, 55, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		userPanel.setLayout(gbl_panel);
		
		var detailsPanel = new JPanel();
		GridBagConstraints gbc_detailsPanel = new GridBagConstraints();
		gbc_detailsPanel.fill = GridBagConstraints.BOTH;
		gbc_detailsPanel.insets = new Insets(0, 0, 5, 0);
		gbc_detailsPanel.gridx = 0;
		gbc_detailsPanel.gridy = 0;
		detailsPanel.setBorder(new TitledBorder("User Details"));
		detailsPanel.setLayout(new GridLayout(2, 2, 5, 5));
		detailsPanel.add(new JLabel("Customer Name:"));
		customerNameLabel = new JLabel(customer.getName());
		detailsPanel.add(customerNameLabel);
		detailsPanel.add(new JLabel("Business Number:"));
		businessNumberlabel = new JLabel(Integer.toString(customer.getBusinessNumber()));
		detailsPanel.add(businessNumberlabel);
		userPanel.add(detailsPanel, gbc_detailsPanel);
		
		changePasswordButton = new JButton("Change Password");
		
		GridBagConstraints gbc_changePasswordButton = new GridBagConstraints();
		gbc_changePasswordButton.gridx = 0;
		gbc_changePasswordButton.gridy = 1;
		userPanel.add(changePasswordButton, gbc_changePasswordButton);

		add(userPanel);

		var deliveryAddress = new AddressPanel(new AddressModel(customer.getProfile().getDeliveryAddress()));
		deliveryAddress.setBorder(new TitledBorder("Delivery Address"));
		add(deliveryAddress);

		var billingAddress = new AddressPanel(new AddressModel(customer.getProfile().getDeliveryAddress()));
		billingAddress.setBorder(new TitledBorder("Billing Address"));
		add(billingAddress);
	}
	
}

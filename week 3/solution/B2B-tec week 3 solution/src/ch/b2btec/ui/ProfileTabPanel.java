package ch.b2btec.ui;

import java.awt.event.ActionEvent;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.ui.generated.ProfileTabBase;

public class ProfileTabPanel extends ProfileTabBase {

	private static final long serialVersionUID = 2737328002953677786L;

	public ProfileTabPanel(Customer customer) {
		super(customer);
		changePasswordButton.addActionListener(this::changePassword);
	}
	
	private void changePassword(ActionEvent event) {
		
	}
}

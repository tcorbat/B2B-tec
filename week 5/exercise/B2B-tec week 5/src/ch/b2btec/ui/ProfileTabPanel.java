package ch.b2btec.ui;

import java.awt.event.ActionEvent;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.services.UserManagement;
import ch.b2btec.ui.generated.ChangePasswordDialog;
import ch.b2btec.ui.generated.ProfileTabBase;

public class ProfileTabPanel extends ProfileTabBase {

	private static final long serialVersionUID = 2737328002953677786L;
	private final UserManagement userManagement;
	private final Customer customer;

	public ProfileTabPanel(UserManagement userManagement, Customer customer) {
		super(customer);
		this.userManagement = userManagement;
		this.customer = customer;
		changePasswordButton.addActionListener(this::changePassword);
	}
	
	private void changePassword(ActionEvent event) {
		showChangePasswordDialog();
	}

	private void showChangePasswordDialog() {
		var changePasswordDialog = new ChangePasswordDialog();
		new ChangePasswordController(changePasswordDialog, userManagement, customer);
		changePasswordDialog.setVisible(true);

	}
}

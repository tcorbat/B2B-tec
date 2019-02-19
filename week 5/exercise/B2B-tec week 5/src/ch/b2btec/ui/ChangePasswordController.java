package ch.b2btec.ui;

import java.awt.event.ActionEvent;

import ch.b2btec.bl.domain.Credentials;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.services.UserManagement;
import ch.b2btec.ui.generated.ChangePasswordDialog;

public class ChangePasswordController {
	private final ChangePasswordDialog dialog;
	private final UserManagement userManagement;
	private final Customer user;

	public ChangePasswordController(ChangePasswordDialog dialog, UserManagement userManagement, Customer user) {
		this.dialog = dialog;
		this.userManagement = userManagement;
		this.user = user;
		dialog.getCancelButton().addActionListener(this::cancel);
		dialog.getChangeButton().addActionListener(this::change);
	}

	public void cancel(ActionEvent event) {
		dialog.dispose();
	}

	public void change(ActionEvent event) {
		var newPassword = String.valueOf(dialog.getNewPasswordField().getPassword());
		var confirmPassword = String.valueOf(dialog.getConfirmPasswordField().getPassword());
		if (!newPassword.equals(confirmPassword)) {
			dialog.getMessageLabel().setText("New password and confirm password must match");
			return;
		}
		if (!Credentials.isValidPassword(newPassword)) {
			dialog.getMessageLabel().setText("Invalid password: Must not be empty or contain whitespace");
			return;
		}
		var currentPassword = String.valueOf(dialog.getCurrentPasswordField().getPassword());
		var credentials = user.getProfile().getCredentials();
		if (!credentials.verifyPassword(currentPassword)) {
			dialog.getMessageLabel().setText("Incorrect password");
			return;
		}
		userManagement.changePassword(user, String.valueOf(currentPassword), String.valueOf(newPassword));
		dialog.dispose();
	}
}

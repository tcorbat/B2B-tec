package ch.b2btec.ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import ch.b2btec.bl.services.UserManagement;

public class ChangePasswordFrame extends JFrame {

	private static final long serialVersionUID = -6801894620231519751L;
	private JPasswordField currentPasswordField;
	private JPasswordField newPasswordField;
	private JPasswordField confirmPasswordField;

	public ChangePasswordFrame(UserManagement userManagement) {
		setTitle("Change Password");
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblCurrentPassword = new JLabel("Current Password:");
		lblCurrentPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCurrentPassword = new GridBagConstraints();
		gbc_lblCurrentPassword.anchor = GridBagConstraints.EAST;
		gbc_lblCurrentPassword.insets = new Insets(5, 5, 5, 5);
		gbc_lblCurrentPassword.gridx = 1;
		gbc_lblCurrentPassword.gridy = 0;
		getContentPane().add(lblCurrentPassword, gbc_lblCurrentPassword);
		
		currentPasswordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(5, 5, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 0;
		getContentPane().add(currentPasswordField, gbc_passwordField);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewPassword = new GridBagConstraints();
		gbc_lblNewPassword.anchor = GridBagConstraints.EAST;
		gbc_lblNewPassword.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewPassword.gridx = 1;
		gbc_lblNewPassword.gridy = 1;
		getContentPane().add(lblNewPassword, gbc_lblNewPassword);
		
		newPasswordField = new JPasswordField();
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.insets = new Insets(5, 5, 5, 5);
		gbc_passwordField_1.gridx = 2;
		gbc_passwordField_1.gridy = 1;
		getContentPane().add(newPasswordField, gbc_passwordField_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.insets = new Insets(5, 5, 5, 5);
		gbc_lblConfirmPassword.anchor = GridBagConstraints.EAST;
		gbc_lblConfirmPassword.gridx = 1;
		gbc_lblConfirmPassword.gridy = 2;
		getContentPane().add(lblConfirmPassword, gbc_lblConfirmPassword);
		
		confirmPasswordField = new JPasswordField();
		GridBagConstraints gbc_passwordField_2 = new GridBagConstraints();
		gbc_passwordField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_2.insets = new Insets(5, 5, 5, 5);
		gbc_passwordField_2.gridx = 2;
		gbc_passwordField_2.gridy = 2;
		getContentPane().add(confirmPasswordField, gbc_passwordField_2);
		
		JButton cancelButton = new JButton("Cancel");
		GridBagConstraints gbc_cancelButton = new GridBagConstraints();
		gbc_cancelButton.anchor = GridBagConstraints.EAST;
		gbc_cancelButton.insets = new Insets(5, 5, 5, 5);
		gbc_cancelButton.gridx = 1;
		gbc_cancelButton.gridy = 3;
		getContentPane().add(cancelButton, gbc_cancelButton);
		
		JButton changeButton = new JButton("Change Password");
		GridBagConstraints gbc_changeButton = new GridBagConstraints();
		gbc_changeButton.insets = new Insets(5, 5, 5, 5);
		gbc_changeButton.gridx = 2;
		gbc_changeButton.gridy = 3;
		getContentPane().add(changeButton, gbc_changeButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.RED);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		
	}
}

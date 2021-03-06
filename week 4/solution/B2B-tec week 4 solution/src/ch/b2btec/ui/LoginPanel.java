package ch.b2btec.ui;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import ch.b2btec.ui.generated.LoginPanelBase;
import ch.b2btec.ui.models.LoginModel;
import ch.b2btec.ui.models.LoginModel.Property;

public class LoginPanel extends LoginPanelBase implements PropertyChangeListener {

	private static final long serialVersionUID = -4281030764532126999L;

	private final LoginModel model;

	public LoginPanel(LoginModel model) {
		this.model = model;
		model.addPropertyChangeListener(this);
		btnLogin.addActionListener(this::loginButtonPressed);
		getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "Login");
		getActionMap().put("Login", new AbstractAction() {
			private static final long serialVersionUID = 6541869527859249405L;
			@Override
			public void actionPerformed(ActionEvent e) {
				loginButtonPressed(e);
			}
		});
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Property property = Property.valueOf(evt.getPropertyName());
		switch (property) {
		case Message:
			lblMessage.setText(model.getMessage());
			break;
		case Username:
			txtUsername.setText(model.getUsername());
			break;
		case Password:
			passwordField.setText(model.getPassword());
			break;
		}
	}

	private void loginButtonPressed(ActionEvent event) {
		login();
	}

	private void login() {
		model.setUsername(txtUsername.getText());
		model.setPassword(String.valueOf(passwordField.getPassword()));
		model.login();
	}
}

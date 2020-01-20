package ch.b2btec.ui.models;

import static ch.b2btec.utils.StringUtils.isNullOrEmpty;

import java.util.function.Consumer;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.services.UserManagement;
import ch.b2btec.utils.PropertyObservable;

public class LoginModel extends PropertyObservable {
	public enum Property {
		Username, Password, Message
	}

	private static final String USERNAME_IS_EMPTY = "Username must not be empty";
	private static final String PASSWORD_IS_EMPTY = "Password must not be empty";
	private static final String INVALID_LOGIN = "Invalid username/password combination";
	private static final String LOGIN_SUCCESSFUL = "Login successful, welcome ";

	private String username;
	private String password;
	private String message;
	private final UserManagement userManagement;
	private final Consumer<Customer> successfulLoginAction;

	public LoginModel(UserManagement userManagement, Consumer<Customer> successfulLoginAction) {
		this.userManagement = userManagement;
		this.successfulLoginAction = successfulLoginAction;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getMessage() {
		return message;
	}

	public void setUsername(String newUsername) {
		String currentUsername = username;
		username = newUsername;
		observable.firePropertyChange(Property.Username.name(), currentUsername, newUsername);
	}

	public void setPassword(String newPassword) {
		String currentPassword = password;
		password = newPassword;
		observable.firePropertyChange(Property.Password.name(), currentPassword, newPassword);
	}

	private void setMessage(String newMessage) {
		String currentMessage = message;
		message = newMessage;
		observable.firePropertyChange(Property.Message.name(), currentMessage, newMessage);
	}

	public void login() {
		if (isNullOrEmpty(username)) {
			setMessage(USERNAME_IS_EMPTY);
			return;
		}
		if (isNullOrEmpty(password)) {
			setMessage(PASSWORD_IS_EMPTY);
			return;
		}
		var loginAttempt = userManagement.login(username, password);
		loginAttempt.ifPresentOrElse(customer -> {
			setMessage(LOGIN_SUCCESSFUL + customer.getName());
			successfulLoginAction.accept(customer);
		}, () -> setMessage(INVALID_LOGIN));
	}
}

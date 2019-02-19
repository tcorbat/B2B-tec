package ch.b2btec.bl.services.impl;

import java.util.Collection;
import java.util.Optional;
import java.util.TreeMap;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.services.DataLoader;
import ch.b2btec.bl.services.DataSaver;
import ch.b2btec.bl.services.UserManagement;

public class UserManagementService implements UserManagement {
	private final TreeMap<String, Customer> customers = new TreeMap<String, Customer>();
	private DataLoader loader;
	private DataSaver saver;

	public UserManagementService() {
	}

	public UserManagementService(DataLoader loader, DataSaver saver) {
		this.loader = loader;
		load();
		this.saver = saver;
	}

	@Override
	public Optional<Customer> login(String username, String password) {
		Optional<Customer> customer = Optional.ofNullable(customers.get(username.toLowerCase()));
		return customer.filter(c -> c.getProfile().getCredentials().verifyPassword(password));
	}

	public void addCustomer(Customer newCustomer) {
		var loginName = newCustomer.getProfile().getCredentials().getLoginName();
		if (customers.containsKey(loginName)) {
			throw new IllegalArgumentException(
					String.format("Customer with username ''%1$s'' already exists", loginName));
		}
		customers.put(loginName, newCustomer);
	}

	private void load() {
		var loadedCustomers = loader.loadCustomers();
		loadedCustomers.forEach(
				customer -> customers.put(customer.getProfile().getCredentials().getLoginName(),
						customer));
	}

	@Override
	public void changePassword(Customer user, String currentPassword, String newPassword) {
		var loginName = user.getProfile().getCredentials().getLoginName();
		if (!customers.containsKey(loginName)) {
			throw new IllegalArgumentException(String.format("Unknown customer with username '%1$s'", loginName));
		}
		var customer = customers.get(loginName);
		var credentials = customer.getProfile().getCredentials();
		credentials.changePassword(currentPassword, newPassword);
		if (saver != null) {
			saver.writeCredentials(credentials);
		}
	}

	public Collection<Customer> getAllCustomers() {
		return customers.values();
	}
}

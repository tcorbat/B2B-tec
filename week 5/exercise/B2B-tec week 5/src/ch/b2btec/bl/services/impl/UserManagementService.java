package ch.b2btec.bl.services.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;
import java.util.TreeMap;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.services.UserManagement;
import ch.b2btec.store.DataStore;
import ch.b2btec.store.db.Database;

public class UserManagementService implements UserManagement {
	private final TreeMap<String, Customer> customers = new TreeMap<String, Customer>();

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

	// TODO: 5.2 Add a DataStore parameter to load
	// Change the code to load the customers through the new parameter
	// Pass the Database instance to the load call in ApplicationContext
	public static UserManagementService load() throws FileNotFoundException, IOException {
		var userManagement = new UserManagementService();
		var store = Database.getInstance();
		store.stream().map(DataStore::loadCustomers).flatMap(Collection::stream)
				.forEach(customer -> userManagement.customers.put(customer.getProfile().getCredentials().getLoginName(),
						customer));
		return userManagement;
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
		Database.getInstance().ifPresent((db) -> db.writeCredentials(credentials));
	}

	public Collection<Customer> getAllCustomers() {
		return customers.values();
	}
}

package ch.b2btec.bl.services.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Optional;
import java.util.TreeMap;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.services.UserManagement;

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
			throw new IllegalArgumentException(new MessageFormat("Customer with username '{0}' already exists").format(loginName));
		}
		customers.put(loginName, newCustomer);
	}

	public static UserManagementService load(String filePath) throws FileNotFoundException, IOException {
		return new DataReader(filePath).read(UserManagementService.class);
	}
}

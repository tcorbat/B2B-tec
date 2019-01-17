package ch.b2btec.bl;

import java.util.Optional;
import java.util.TreeMap;

import ch.b2btec.bl.domain.Address;
import ch.b2btec.bl.domain.Credentials;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Profile;

public class UserManagementService implements UserManagement {
	private final TreeMap<String, Customer> customers = new TreeMap<String, Customer>();

	public UserManagementService() {
		var address = new Address("Toolstreet", 5, 98765, "Michigan", "USA");
		var credentials = new Credentials("al", "flanel");
		var profile = new Profile(credentials, address);
		var customer = new Customer("Al Borland", 555, profile);
		customers.put(credentials.getLoginName(), customer);
	}

	@Override
	public Optional<Customer> login(String username, String password) {
		Optional<Customer> customer = Optional.ofNullable(customers.get(username.toLowerCase()));
		return customer.filter(c -> c.getProfile().getCredentials().verifyPassword(password));
	}

}

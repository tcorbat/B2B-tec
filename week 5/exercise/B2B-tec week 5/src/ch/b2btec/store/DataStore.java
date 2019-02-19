package ch.b2btec.store;

import java.util.Collection;

import ch.b2btec.bl.domain.Credentials;
import ch.b2btec.bl.domain.Customer;

//TODO: 5.3 Move this interface to the Business Layer (ch.b2btec.cl.services)
public interface DataStore {
	void writeCredentials(Credentials credentials);

	void writeCustomer(Customer customer);

	Collection<Customer> loadCustomers();
}

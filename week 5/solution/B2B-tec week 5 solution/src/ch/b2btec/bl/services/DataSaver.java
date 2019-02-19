package ch.b2btec.bl.services;

import ch.b2btec.bl.domain.Credentials;
import ch.b2btec.bl.domain.Customer;

public interface DataSaver {
	void writeCredentials(Credentials credentials);

	void writeCustomer(Customer customer);
}

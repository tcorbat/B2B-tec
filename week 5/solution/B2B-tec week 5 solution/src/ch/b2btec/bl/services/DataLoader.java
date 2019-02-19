package ch.b2btec.bl.services;

import java.util.Collection;

import ch.b2btec.bl.domain.Customer;

public interface DataLoader {
	Collection<Customer> loadCustomers();
}

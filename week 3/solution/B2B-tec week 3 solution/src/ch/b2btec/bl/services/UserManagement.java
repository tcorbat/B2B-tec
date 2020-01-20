package ch.b2btec.bl.services;

import java.util.Optional;

import ch.b2btec.bl.domain.Customer;

public interface UserManagement {

	Optional<Customer> login(String username, String password);

}

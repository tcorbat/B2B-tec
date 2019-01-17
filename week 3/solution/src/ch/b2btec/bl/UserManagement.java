package ch.b2btec.bl;

import java.util.Optional;

import ch.b2btec.bl.domain.Customer;

public interface UserManagement {

	Optional<Customer> login(String username, String password);

}

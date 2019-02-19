package ch.b2btec.store.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import ch.b2btec.bl.domain.Credentials;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.services.DataStore;

public class Database implements DataStore {
	private final Connection connection;
	private final CredentialsTable credentialsTable;
	private final AddressTable addressTable;
	private final CustomerTable customerTable;

	public Database() throws SQLException {
		this.connection = DriverManager.getConnection("jdbc:h2:./database/b2b-tec", "b2b-tec-admin", "1234");
		this.credentialsTable = new CredentialsTable(connection);
		this.addressTable = new AddressTable(connection);
		this.customerTable = new CustomerTable(connection, credentialsTable, addressTable);
	}

	public void writeCredentials(Credentials credentials) {
		System.out.print("Updating credentials...");
		try {
			credentialsTable.update(credentials);
			System.out.println("success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void writeCustomer(Customer customer) {
		System.out.print("Updating customer...");
		try {
			customerTable.insertCustomer(customer);
			System.out.println("success");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() throws SQLException {
		connection.close();
	}

	@Override
	public List<Customer> loadCustomers() {
		System.out.print("Loading customers...");
		try {
			List<Customer> customers = customerTable.loadCustomers();
			System.out.println("success");
			return customers;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

package ch.b2btec.store.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Profile;

public class CustomerTable extends Table {

	private static final String CUSTOMER_TABLE = "Customer";

	// @formatter:off
	private static final String CREATE_TABLE_QUERY = String.format(
				"CREATE TABLE %1$s (" +
				"	id INT NOT NULL AUTO_INCREMENT," + 
				"	name VARCHAR(100) NOT NULL," + 
				"	business_number INT NOT NULL," +
				"	credentials_id INT NOT NULL," +
				"	delivery_address_id INT NOT NULL," +
				"	billing_address_id INT NOT NULL," + 
				"	PRIMARY KEY (id)," +
				"	FOREIGN KEY (credentials_id) REFERENCES credentials(id)," +
				"	FOREIGN KEY (delivery_address_id) REFERENCES address(id), " + 
				"	FOREIGN KEY (billing_address_id) REFERENCES address(id)" +
				");",
				CUSTOMER_TABLE);
	private static final String INSERT_QUERY = String.format(
				"INSERT INTO %1$s (name, business_number, credentials_id, delivery_address_id, billing_address_id)" + 
						"		VALUES(?, ?, ?, ?, ?);",
				CUSTOMER_TABLE);
	private static final String ALL_CUSTOMERS = String.format(
				"SELECT " + 
				"	name," + 
				"	business_number," +
				"	credentials_id," + 
				"	delivery_address_id," + 
				"	billing_address_id " + 
				"FROM " + 
				"	%1$s;",
				CUSTOMER_TABLE);
	// @formatter:on

	private final CredentialsTable credentialsTable;
	private final AddressTable addressTable;
	
	protected CustomerTable(Connection connection, CredentialsTable credentialsTable, AddressTable addressTable)
			throws SQLException {
		super(connection, CUSTOMER_TABLE);
		this.credentialsTable = credentialsTable;
		this.addressTable = addressTable;
	}

	@Override
	protected void createTable() throws SQLException {
		System.out.println("Creating Customer table");
		try (var statement = connection.createStatement()) {
			statement.execute(CREATE_TABLE_QUERY);
		}
	}

	public int insertCustomer(Customer customer, int credentialsId, int deliveryAddressId, int billingAddressId)
			throws SQLException {
		try (var statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, customer.getName());
			statement.setInt(2, customer.getBusinessNumber());
			statement.setInt(3, credentialsId);
			statement.setInt(4, deliveryAddressId);
			statement.setInt(5, billingAddressId);
			statement.execute();
			try (var resultSet = statement.getGeneratedKeys()) {
				if (resultSet.next()) {
					return resultSet.getInt(1);
				}
			}
		}
		throw new RuntimeException("Insert succeeded but did not result in a new primary key!");
	}

	public void insertCustomer(Customer customer) throws SQLException {
		var profile = customer.getProfile();
		var deliveryAddress = profile.getDeliveryAddress();
		var deliveryAddressId = addressTable.insertAddress(deliveryAddress);
		var billingAddress = profile.getBillingAddress();
		var billingAddressId = addressTable.insertAddress(billingAddress);
		var credentials = profile.getCredentials();
		var credentialsId = credentialsTable.insert(credentials);
		insertCustomer(customer, credentialsId, deliveryAddressId, billingAddressId);
	}

	private static final class CustomerRecord {
		public final String name;
		public final int businessNumber;
		public final int credentialsId;
		public final int deliveryAddressId;
		public final int billingAddressId;

		public CustomerRecord(String name, int businessNumber, int credentialsId, int deliveryAddressId,
				int billingAddressId) {
			this.name = name;
			this.businessNumber = businessNumber;
			this.credentialsId = credentialsId;
			this.deliveryAddressId = deliveryAddressId;
			this.billingAddressId = billingAddressId;
		}

	}

	public List<Customer> loadCustomers() throws SQLException {
		try (var statement = connection.createStatement(); var resultSet = statement.executeQuery(ALL_CUSTOMERS);) {
			var customerRecords = new ArrayList<CustomerRecord>();
			while (resultSet.next()) {
				var record = new CustomerRecord(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3),
						resultSet.getInt(4), resultSet.getInt(5));
				customerRecords.add(record);
			}
			var customers = new ArrayList<Customer>();
			for (var record : customerRecords) {
				customers.add(loadCustomer(record));
			}
			return customers;
		}
	}

	private Customer loadCustomer(CustomerRecord record) throws SQLException {
		var credentials = credentialsTable.loadCredentials(record.credentialsId);
		var deliveryAddress = addressTable.loadAddress(record.deliveryAddressId);
		var billingAddress = addressTable.loadAddress(record.billingAddressId);
		var profile = new Profile(credentials, deliveryAddress, billingAddress);
		return new Customer(record.name, record.businessNumber, profile);
	}
}

package ch.b2btec.store.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import ch.b2btec.bl.domain.Address;

public class AddressTable extends Table {

	private static final String ADDRESS_TABLE = "Address";

	// @formatter:off
	private static final String CREATE_TABLE_QUERY = String.format(
				"CREATE TABLE %1$s (" +
				"	id INT NOT NULL AUTO_INCREMENT," + 
				"	street VARCHAR(100) NOT NULL," + 
				"	number INT NOT NULL," + 
				"	zip INT NOT NULL," + 
				"	city VARCHAR(50) NOT NULL," + 
				"	country VARCHAR (50) NOT NULL," + 
				"	PRIMARY KEY (id)" +
				");",
				ADDRESS_TABLE);
	private static final String UPDATE_QUERY = String.format(
				"UPDATE" +
				"	%1$s" +
				"SET" +
				"	street = ?," +
				"	number = ?," + 
				"	zip = ?," + 
				"	city = ?," + 
				"	country = ? " + 
				"WHERE" + 
				"	id = ?;",
				ADDRESS_TABLE);
	private static final String INSERT_QUERY = String.format(
				"INSERT INTO %1$s (street, number, zip, city, country)" + 
						"		VALUES(?, ?, ?, ?, ?);",
				ADDRESS_TABLE);
	private static final String COUNT_QUERY =  String.format(
				"SELECT" +
				"	COUNT(*)" + 
				"FROM" + 
				"	%1$s " + 
				"WHERE" + 
				"	id = ?;", 
				ADDRESS_TABLE);
	private static final String ADDRESS_QUERY = String.format(
			"SELECT" + 
			"	street," + 
			"	number," + 
			"	zip," + 
			"	city," + 
			"	country " + 
			"FROM" + 
			"	%1$s " + 
			"WHERE" + 
			"	id = ?;",
			ADDRESS_TABLE);
	// @formatter:on
	
	public AddressTable(Connection connection) throws SQLException {
		super(connection, ADDRESS_TABLE);
	}

	@Override
	protected void createTable() throws SQLException {
		System.out.println("Creating Address table");
		try (var statement = connection.createStatement()) {
			statement.execute(CREATE_TABLE_QUERY);
		}
	}

	public int insertAddress(Address address) throws SQLException {
		System.out.println("Inserting address");
		try (var statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, address.getStreetName());
			statement.setInt(2, address.getHouseNumber());
			statement.setInt(3, address.getZipCode());
			statement.setString(4, address.getCity());
			statement.setString(5, address.getCountry());
			statement.execute();
			try (var resultSet = statement.getGeneratedKeys()) {
				if (resultSet.next()) {
					return resultSet.getInt(1);
				}
			}
		}
		throw new RuntimeException("Insert succeeded but did not result in a new primary key!");
	}

	public void updateAddress(int id, Address address, String action) throws SQLException {
		if (!isAddressInDatabase(id)) {
			throw new IllegalArgumentException("Unknown address with id: " + id);
		}
		try (var statement = connection.prepareStatement(UPDATE_QUERY)) {
			statement.setString(1, address.getStreetName());
			statement.setInt(2, address.getHouseNumber());
			statement.setInt(3, address.getZipCode());
			statement.setString(4, address.getCity());
			statement.setString(5, address.getCountry());
			statement.setInt(6, id);
			statement.execute();
		}
	}

	private boolean isAddressInDatabase(int addressId) throws SQLException {
		System.out.println("Checking whether address exists: " + addressId);
		try (var statement = connection.prepareStatement(COUNT_QUERY)) {
			statement.setInt(1, addressId);
			try (var result = statement.executeQuery()) {
				var exist = result.next() && result.getInt("COUNT(*)") == 1;
				return exist;
			}
		}
	}

	public Address loadAddress(int addressId) throws SQLException {
		try (var statement = connection.prepareStatement(ADDRESS_QUERY)) {
			statement.setInt(1, addressId);
			try (var resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					var street = resultSet.getString(1);
					var number = resultSet.getInt(2);
					var zip = resultSet.getInt(3);
					var city = resultSet.getString(4);
					var country = resultSet.getString(5);
					return new Address(street, number, zip, city, country);
				}
				throw new IllegalArgumentException("Could not load address with id: " + addressId);
			}
		}
	}
}

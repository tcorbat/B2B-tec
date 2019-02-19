package ch.b2btec.store.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import ch.b2btec.bl.domain.Credentials;

public class CredentialsTable extends Table {

	private static final String CREDENTIALS_TABLE = "Credentials";
	
	// @formatter:off
	private static final String CREATE_TABLE_QUERY = String.format(
				"CREATE TABLE %1$s (" +
				"	id INT NOT NULL AUTO_INCREMENT," +
				"	login VARCHAR(20) NOT NULL UNIQUE," +
				"	hash BINARY(256) NOT NULL," +
				"	salt BINARY(160) NOT NULL," +
				"	PRIMARY KEY(login)" +
				");",
				CREDENTIALS_TABLE);
	private static final String UPDATE_QUERY = String.format(
				"UPDATE" +
				"	%1$s " +
				"SET" +
				"	hash = ?," +
				"	salt = ? " +
				"WHERE" + 
				"	login = ?;",
				CREDENTIALS_TABLE);
	private static final String INSERT_QUERY = String.format(
				"INSERT INTO %1$s (hash, salt, login)" + 
				"		VALUES(?, ?, ?);",
				CREDENTIALS_TABLE);
	private static final String COUNT_QUERY =  String.format(
				"SELECT" +
				"	COUNT(*)" + 
				"FROM" + 
				"	%1$s " + 
				"WHERE" + 
				"	login = ?;", 
				CREDENTIALS_TABLE);
	private static final String CREDENTIALS_QUERY = String.format(
				"SELECT" + 
				"	login," + 
				"	hash," + 
				"	salt " + 
				"FROM" + 
				"	%1$s " + 
				"WHERE" + 
				"	id = ?;",
				CREDENTIALS_TABLE);
	// @formatter:on

	public CredentialsTable(Connection connection) throws SQLException {
		super(connection, CREDENTIALS_TABLE);
	}

	@Override
	protected void createTable() throws SQLException {
		System.out.println("Creating Credentials table");
		try (var statement = connection.createStatement()) {
			statement.execute(CREATE_TABLE_QUERY);
		}
	}

	public int insert(Credentials credentials) throws SQLException {
		try (var statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
			prepareStatement(credentials, statement);
			statement.execute();
			try (var resultSet = statement.getGeneratedKeys()) {
				if (resultSet.next()) {
					return resultSet.getInt(1);
				}
			}
		}
		throw new RuntimeException("Insert succeeded but did not result in a new primary key!");
	}

	public void update(Credentials credentials) throws SQLException {
		System.out.println("Updating credentials");
		if (!areCredentialsInDatabase(credentials.getLoginName())) {
			throw new IllegalArgumentException("Credentials are already stored");
		}
		try (var statement = connection.prepareStatement(UPDATE_QUERY)) {
			prepareStatement(credentials, statement);
			statement.execute();
		}
	}

	private void prepareStatement(Credentials credentials, PreparedStatement statement) throws SQLException {
		var passwordHash = credentials.getPasswordHash();
		var salt = credentials.getSalt();
		var loginName = credentials.getLoginName();
		statement.setBytes(1, passwordHash);
		statement.setBytes(2, salt);
		statement.setString(3, loginName);
	}

	private boolean areCredentialsInDatabase(String login) throws SQLException {
		System.out.println("Checking whether user exists: " + login);
		try (var statement = connection.prepareStatement(COUNT_QUERY)) {
			statement.setString(1, login);
			try (var result = statement.executeQuery()) {
				var exist = result.next() && result.getInt("COUNT(*)") == 1;
				result.close();
				return exist;
			}
		}
	}

	public Credentials loadCredentials(int credentialsId) throws SQLException {
		try (var statement = connection.prepareStatement(CREDENTIALS_QUERY)) {
			statement.setInt(1, credentialsId);
			try (var resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					var loginName = resultSet.getString(1);
					var hash = resultSet.getBytes(2);
					var salt = resultSet.getBytes(3);
					return new Credentials(loginName, hash, salt);
				}
				throw new IllegalArgumentException("Could not load credentials with id: " + credentialsId);
			}
		}
	}
}

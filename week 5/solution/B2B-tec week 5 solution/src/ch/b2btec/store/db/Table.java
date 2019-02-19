package ch.b2btec.store.db;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Table {

	protected final Connection connection;
	protected final String name;

	protected Table(Connection connection, String tableName) throws SQLException {
		this.connection = connection;
		this.name = tableName;
//		dropTable(tableName);
		if (!hasTable(tableName)) {
			createTable();
		}
	}

	protected abstract void createTable() throws SQLException;

	protected boolean hasTable(String tableName) throws SQLException {
		var dbm = connection.getMetaData();
		var tables = dbm.getTables(null, null, tableName.toUpperCase(), null);
		return tables.next();
	}

	protected void dropTable(String tableName) throws SQLException {
		var statement = connection.createStatement();
		var sql = "DROP TABLE " + tableName;
		statement.execute(sql);
	}

}

package ch.b2btec.store;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ch.b2btec.bl.services.DataLoader;
import ch.b2btec.bl.services.DataSaver;
import ch.b2btec.store.db.Database;
import ch.b2btec.store.json.JSONStore;

public class StoreProvider {

	private final Map<PersistencyKind, DataLoader> loaders = new HashMap<>();
	private final Map<PersistencyKind, DataSaver> savers = new HashMap<>();

	public StoreProvider() {
		try {
			var jsonFile = new JSONStore("predefined/users.json");
			loaders.put(PersistencyKind.Json, jsonFile);
			var database = new Database();
			loaders.put(PersistencyKind.Database, database);
			savers.put(PersistencyKind.Database, database);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public DataLoader getDataLoader(PersistencyKind kind) {
		return loaders.get(kind);
	}

	public DataSaver getDataSaver(PersistencyKind kind) {
		return savers.get(kind);
	}
}

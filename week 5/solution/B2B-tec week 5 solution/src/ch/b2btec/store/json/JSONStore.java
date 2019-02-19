package ch.b2btec.store.json;

import java.io.IOException;
import java.util.Collection;

import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.services.DataLoader;
import ch.b2btec.bl.services.impl.DataReader;
import ch.b2btec.bl.services.impl.UserManagementService;

public class JSONStore implements DataLoader {

	private final String filePath;

	public JSONStore(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public Collection<Customer> loadCustomers() {
		try {
			var userManagement = new DataReader(filePath).read(UserManagementService.class);
			return userManagement.getAllCustomers();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}

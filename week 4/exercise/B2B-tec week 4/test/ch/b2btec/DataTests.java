package ch.b2btec;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.google.gson.JsonSyntaxException;

import ch.b2btec.bl.services.impl.CatalogManagementService;
import ch.b2btec.bl.services.impl.UserManagementService;

public class DataTests {

	@Test
	void testCatalogJson() throws Exception {
		try {
			new CatalogManagementService("predefined/catalog.json");
		} catch (JsonSyntaxException jse) {
			fail("Cannot read predefined/catalog.json file. Please make sure the file is present and contains matching data. Run data/HardcodedCatalogBuilder.");
		}
	}

	@Test
	void testUserJson() throws Exception {
		try {
			UserManagementService.load("predefined/users.json");
		} catch (JsonSyntaxException jse) {
			fail("Cannot read predefined/users.json file. Please make sure the file is present and contains matching data. Run data/HardcodedUserDataBuilder.");
		}
	}
}

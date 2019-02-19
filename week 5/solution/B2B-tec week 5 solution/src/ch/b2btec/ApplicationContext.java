package ch.b2btec;

import java.io.FileNotFoundException;
import java.io.IOException;

import ch.b2btec.bl.BusinessContext;
import ch.b2btec.bl.services.CatalogManagement;
import ch.b2btec.bl.services.OrderManagement;
import ch.b2btec.bl.services.UserManagement;
import ch.b2btec.bl.services.impl.CatalogManagementService;
import ch.b2btec.bl.services.impl.OrderManagementService;
import ch.b2btec.bl.services.impl.UserManagementService;
import ch.b2btec.store.PersistencyKind;
import ch.b2btec.store.StoreProvider;

/**
 * Provides the globally needed instances. May be replaced with a
 * Service Locator / Dependency Injection container.
 * 
 */
public class ApplicationContext {
	private final CatalogManagementService catalogManagement;
	private final UserManagementService userManagement;
	private final OrderManagement orderManagement;
	private BusinessContext dataCtx;
	private String[] params;
	
	/**
	 * Creates the application context instance. 
	 * 
	 * @param params Console line arguments to be stored.
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	ApplicationContext(String[] params) throws FileNotFoundException, IOException {
		this.params = params;
		catalogManagement = new CatalogManagementService("predefined/catalog.json");
		var storeProvider = new StoreProvider();
		var dataLoader = storeProvider.getDataLoader(PersistencyKind.Database);
		var dataSaver = storeProvider.getDataSaver(PersistencyKind.Database);
		userManagement = new UserManagementService(dataLoader, dataSaver);
		orderManagement = new OrderManagementService();
	}
	
	/**
	 * Returns the underling data context needed to persist the required
	 * data.
	 * 
	 * @return Returns the one and only database access instance.
	 */
	public BusinessContext getModel() {
		if (dataCtx == null) {
			dataCtx = new BusinessContext("db/shop.db");
		}
		return dataCtx;
	}
	
	/**
	 * @return Returns the provided console line arguments.
	 */
	public String[] getParams() {
		return params;
	}

	public UserManagement getUserManagement() {
		return userManagement;
	}
	
	public CatalogManagement getCatalogManagement() {
		return catalogManagement;
	}

	public OrderManagement getOrderManagement() {
		return orderManagement;
	}
}

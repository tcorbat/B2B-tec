package ch.b2btec;

import ch.b2btec.bl.BusinessContext;
import ch.b2btec.bl.UserManagement;
import ch.b2btec.bl.UserManagementService;

/**
 * Provides the globally needed instances. May be replaced with a
 * Service Locator / Dependency Injection container.
 * 
 * @author sgehrig
 *
 */
public class ApplicationContext {
	private BusinessContext dataCtx;
	private String[] params;
	
	/**
	 * Creates the application context instance. 
	 * 
	 * @param params Console line arguments to be stored.
	 */
	ApplicationContext(String[] params) {
		this.params = params;
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
		return new UserManagementService();
	}
}

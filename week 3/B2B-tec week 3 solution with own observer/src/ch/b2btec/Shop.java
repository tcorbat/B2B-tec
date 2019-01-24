package ch.b2btec;

import ch.b2btec.ui.MainController;
import ch.b2btec.ui.MainFrame;

/**
 * Provides the applications entry point and basic application configuration facilities.
 * 
 * @author sgehrig
 *
 */
public class Shop {
	private ApplicationContext context;
	private MainController controller;
	
	/**
	 * Creates the UI application instance.
	 */
	Shop() {
	}
	
	/**
	 * Initializes the current Swing application by bootstrapping the
	 * MainFrame and the underlying view.
	 */
	void run(String[] args) {
		// create application and window specific instances
		try {
			context = new ApplicationContext(args);
			MainFrame mainWindow = new MainFrame(context);
			controller = new MainController(mainWindow, context);
			controller.show();
		} catch (Exception e) {
			System.err.println("B2B-tec could not start:");
			e.printStackTrace();
		}
	}
}

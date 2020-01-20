package ch.b2btec;

import java.awt.EventQueue;

import ch.b2btec.log.Logger;

/**
 * Provides the applications entry point and basic application configuration facilities.
 * 
 * @author sgehrig
 *
 */
public class Application {
	private static Logger LOGGER = Logger.getLogger(Application.class.getName());
	
	/**
	 * Entry point method.
	 * 
	 * @param args Provides console line arguments.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {			
					new Shop().run(args);
				} catch (Exception e) {
					LOGGER.fatal("Application crash: An unknown error occured.", e);
				}
			}
		});
	}
}

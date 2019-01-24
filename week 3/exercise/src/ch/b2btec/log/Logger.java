package ch.b2btec.log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Provides a simple logging interface; implementation inspired by log4j.
 * 
 * @author sgehrig
 */
public class Logger {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");

	private String name;
	
	private Logger(String name) {
		this.name = name;
	}
	
	/**
	 * Logs a message to the console. 
	 * @param message Message to be logged.
	 */
	public void info(String message) {
		log(message, "INFO", null);
	}
	
	/**
	 * Logs a message to the console. 
	 * @param message Message to be logged.
	 * @param message Error to be logged.
	 */
	public void fatal(String message, Exception e) {
		log(message, "FATAL", e);
	}
	
	private void log(String message, String severity, Exception e) {
		System.out.printf("%s %6s  %s %s", DATE_FORMAT.format(new Date()), severity, name, message);
		
		if (e != null) {
			System.out.print(e);
		}
	}
	
	/**
	 * Returns a new Logging instance by configuring the name of the logger.
	 * 
	 * @param loggerName Name of the logger; normally the class name of the log entry source.
	 * @return Returns the created log instance.
	 */
	public static Logger getLogger(String loggerName) {
		return new Logger(loggerName);
	}
}

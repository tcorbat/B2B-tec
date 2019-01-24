package ch.hsr.examples.proxy;

/**
 * Base class for all originals.
 * 
 * @author sgehrig
 */
public abstract class AbstractOriginal {

	protected AbstractOriginal() {
	}
	
	/**
	 * Method to be intercepted by proxies.
	 */
	public abstract Object doAction();
}

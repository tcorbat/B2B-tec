package ch.hsr.examples.observer;


public interface Observer {
	/**
	 * Notifies the underlying object about an update. 
	 * 
	 * @param eventData
	 */
	void update(Object eventData);
}

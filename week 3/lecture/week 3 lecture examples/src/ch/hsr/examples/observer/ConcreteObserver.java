package ch.hsr.examples.observer;

/**
 * Receives events by an underlying subject.
 * 
 * @author sgehrig
 */
public class ConcreteObserver implements Observer {
	private Object updatedValue;

	public Object getUpdatedValue() {
		return updatedValue;
	}
	
	@Override
	public void update(Object eventData) {
		updatedValue = eventData;
	}
}

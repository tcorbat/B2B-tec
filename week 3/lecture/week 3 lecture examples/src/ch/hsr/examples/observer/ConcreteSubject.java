package ch.hsr.examples.observer;

/**
 * Concrete subject which has its own state and notifies observers about its change.
 * 
 * @author sgehrig
 */
public class ConcreteSubject extends Subject {
	private Object value;
	
	public Object getValue() {
		return value;
	}
	public void setValue(Object toSet) {
		value = toSet;
		notify(toSet);
	}

}

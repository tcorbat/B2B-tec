package ch.hsr.examples.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all subjects. Contains logic to store and notify observers.
 * 
 * @author sgehrig
 */
public abstract class Subject {
	private final List<Observer> observers = new ArrayList<Observer>();
	
	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void detach(Observer observer) {
		observers.remove(observer);
	}

	protected void notify(Object eventData) {
		for (Observer obs : observers) { 
			obs.update(eventData);
		}
	}
}

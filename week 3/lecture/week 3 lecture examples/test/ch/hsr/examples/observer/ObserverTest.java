package ch.hsr.examples.observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ObserverTest {

	@Test
	void test_observer_updates() {
		ConcreteObserver observer1 = new ConcreteObserver();
		ConcreteObserver observer2 = new ConcreteObserver();
		
		// setup phase
		ConcreteSubject toObserve = new ConcreteSubject();
		toObserve.attach(observer1);
		toObserve.attach(observer2);
		
		// notification phase
		Object newValue = new Object();
		toObserve.setValue(newValue);
		assertSame(newValue, observer1.getUpdatedValue(), "Value must be set to the first observer.");
		assertSame(newValue, observer2.getUpdatedValue(), "Value must be set to the second observer.");
	}

}

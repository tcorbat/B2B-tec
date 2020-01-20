package ch.b2btec.bl.models.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ch.b2btec.ui.models.ShoppingCartModel;

public class ShoppingCartModelObserverMock {
	
	private final List<PropertyChangeEvent> expectedEvents;
	private final List<PropertyChangeEvent> recordedEvents = new ArrayList<>();

	public ShoppingCartModelObserverMock(ShoppingCartModel model, PropertyChangeEvent... expectedEvents) {
		this.expectedEvents = Arrays.asList(expectedEvents);
		model.addPropertyChangeListener(this::receiveEvent);
	}

	private void receiveEvent(PropertyChangeEvent event) {
		recordedEvents.add(event);
	}

	public void assertEvents() {
		var expectedEventStrings = String.join("\n",
				expectedEvents.stream().map(this::eventToString).toArray(String[]::new));
		var recordedEventStrings = String.join("\n",
				recordedEvents.stream().map(this::eventToString).toArray(String[]::new));
		assertEquals(expectedEventStrings, recordedEventStrings);
	}

	private String eventToString(PropertyChangeEvent event) {
		return event.toString();
	}
}

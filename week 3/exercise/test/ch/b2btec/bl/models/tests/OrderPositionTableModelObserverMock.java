package ch.b2btec.bl.models.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;

import ch.b2btec.ui.models.OrderPositionTableModel;

public class OrderPositionTableModelObserverMock {
	
	private final List<TableModelEvent> expectedEvents;
	private final List<TableModelEvent> recordedEvents = new ArrayList<>();

	public OrderPositionTableModelObserverMock(OrderPositionTableModel model, TableModelEvent... expectedEvents) {
		this.expectedEvents = Arrays.asList(expectedEvents);
		model.addTableModelListener(this::receiveEvent);
	}

	private void receiveEvent(TableModelEvent event) {
		recordedEvents.add(event);
	}

	public void assertEvents() {
		var expectedEventStrings = String.join("\n",
				expectedEvents.stream().map(this::eventToString).toArray(String[]::new));
		var recordedEventStrings = String.join("\n",
				recordedEvents.stream().map(this::eventToString).toArray(String[]::new));
		assertEquals(expectedEventStrings, recordedEventStrings);
	}

	private String eventToString(TableModelEvent event) {
		return event.toString();
	}
}

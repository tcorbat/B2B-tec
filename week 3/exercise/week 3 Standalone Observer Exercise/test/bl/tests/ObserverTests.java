package bl.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import bl.DomainModel;
import infrastructure.ModelObserver;

class ObserverTests {

	private static class ObserverMock implements ModelObserver {

		private final int expectedNumberOfCalls;
		private int modelHasChangedCount = 0;

		public ObserverMock(int expectedNumberOfCalls) {
			this.expectedNumberOfCalls = expectedNumberOfCalls;
		}

		@Override
		public void modelHasChanged() {
			modelHasChangedCount++;
		}

		public void assertNotifications() {
			assertEquals(expectedNumberOfCalls, modelHasChangedCount);
		}
	}

	@Test
	void testSingleObserverCall() {
		var sut = new DomainModel();
		var mockObserver = new ObserverMock(1);
		sut.addObserver(mockObserver);
		sut.setData("new data");
		mockObserver.assertNotifications();
	}

	@Test
	void testMultipleObserverCalls() {
		var sut = new DomainModel();
		var mockObserver = new ObserverMock(1);
		sut.addObserver(mockObserver);
		sut.setData("new data");
		mockObserver.assertNotifications();
	}
}

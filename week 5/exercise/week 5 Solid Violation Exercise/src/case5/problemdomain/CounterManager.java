package case5.problemdomain;

import case5.storage.CounterStore;

public class CounterManager {
	private Counter counter = null;

	public Counter getCounter() {
		if (counter == null) {
			var store = new CounterStore();
			counter = store.load().orElse(new Counter());
		}
		return counter;
	}

	public void shutdown() {
		if (counter != null) {
			var store = new CounterStore();
			store.store(counter);
		}
	}
}

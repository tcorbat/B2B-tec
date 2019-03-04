package case5.problemdomain;


public class CounterManager {
	private final ICounterStore store;
	private Counter counter = null;

	public CounterManager(ICounterStore store) {
		this.store = store;
	}

	public Counter getCounter() {
		if (counter == null) {
			counter = store.load().orElse(new Counter());
		}
		return counter;
	}

	public void shutdown() {
		if (counter != null) {
			store.store(counter);
		}
	}
}

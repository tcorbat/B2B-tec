
public class GlobalCounter {
	private int value = 0;
	private static GlobalCounter instance = new GlobalCounter();

	private GlobalCounter() {
	};

	public static GlobalCounter getInstance() {
		return instance;
	}

	public int getAndIncrementValue() {
		return value++;
	}

	// for testing purpose only
	public void reset() {
		value = 0;
	}
}

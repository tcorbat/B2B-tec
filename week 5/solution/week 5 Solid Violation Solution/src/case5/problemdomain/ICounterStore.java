package case5.problemdomain;

import java.util.Optional;

public interface ICounterStore {
	public void store(Counter counter);
	public Optional<Counter> load();
}

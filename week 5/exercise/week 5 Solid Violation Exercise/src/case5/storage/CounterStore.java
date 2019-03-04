package case5.storage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

import case5.problemdomain.Counter;

public class CounterStore {

	private static final String STORE_FILE = "CounterStore.data";

	public void store(Counter counter) {
		try (var stream = new ObjectOutputStream(new FileOutputStream(STORE_FILE))) {
			stream.writeObject(counter);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Optional<Counter> load() {
		try (var stream = new ObjectInputStream(new FileInputStream(STORE_FILE))) {
			return Optional.of((Counter) stream.readObject());
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
}

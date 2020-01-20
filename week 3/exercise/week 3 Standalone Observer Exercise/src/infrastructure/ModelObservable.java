package infrastructure;

import java.util.ArrayList;
import java.util.List;

public class ModelObservable {

	private List<ModelObserver> observers = new ArrayList<>();

	public void publishChange() {
		observers.stream().forEach(ModelObserver::modelHasChanged);
	}

	public void addObserver(ModelObserver observer) {
		observers.add(observer);
	}
}

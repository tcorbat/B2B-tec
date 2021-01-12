package infrastructure;

@FunctionalInterface
public interface ModelObserver {
	void modelHasChanged();
}

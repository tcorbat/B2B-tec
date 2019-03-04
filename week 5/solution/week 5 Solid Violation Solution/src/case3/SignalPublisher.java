package case3;

public interface SignalPublisher {

	void subscribeForSignal(Runnable callback);

	void unsubscribeFromSignal(Runnable callback);

}
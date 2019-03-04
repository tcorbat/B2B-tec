package case3;

public interface SignalEmitterInterface {
	void setInterval(int millis);
	void start();
	void stop();

	void subscribeForSignal(Runnable callback);
	void unsubscribeFromSignal(Runnable callback);
}

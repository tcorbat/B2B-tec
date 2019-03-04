package case3;

import java.time.LocalTime;

public class SignalMonitor {

	private Runnable callback = () -> {
		System.out.println(LocalTime.now() + ": SignalMonitor callback received");
	};
	private SignalPublisher emitter;

	public SignalMonitor(SignalPublisher emitter) {
		this.emitter = emitter;
		emitter.subscribeForSignal(callback);
	}

	public void disable() {
		emitter.unsubscribeFromSignal(callback);
	}

}

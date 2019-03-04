package case3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class SignalEmitter implements SignalEmitterInterface {

	private final AtomicInteger interval;
	private final AtomicBoolean shutdown = new AtomicBoolean(false);
	private Thread ticker;
	private final Set<Runnable> callbacks = Collections.synchronizedSet(new HashSet<>());

	public SignalEmitter(int interval) {
		this.interval = new AtomicInteger(interval);
	}

	@Override
	public void setInterval(int interval) {
		if (interval <= 0) {
			throw new IllegalArgumentException("Argument interval must not be zero or negative");
		}
		this.interval.set(interval);
		ticker.interrupt();
	}

	public void start() {
		if (ticker != null && ticker.isAlive()) {
			throw new RuntimeException("Cannot start running emitter");
		}
		shutdown.set(false);
		ticker = new Thread(this::runTicker);
		ticker.start();
	}

	private void runTicker() {
		while (!shutdown.get()) {
			try {
				Thread.sleep(interval.get());
				synchronized (callbacks) {
					callbacks.forEach(Runnable::run);
				}
			} catch (InterruptedException e) {
			}
		}
	}

	public void stop() {
		shutdown.set(true);
		ticker.interrupt();
		try {
			ticker.join();
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void subscribeForSignal(Runnable callback) {
		callbacks.add(callback);
	}

	@Override
	public void unsubscribeFromSignal(Runnable callback) {
		callbacks.remove(callback);
	}

}

package case3;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		var emitter = new SignalEmitter(1000);

		var monitor = new SignalMonitor(emitter);

		System.out.println("Starting emitter");
		emitter.start();

		System.out.println("Main Sleeping");
		Thread.sleep(5000);

		System.out.println("Setting interval");
		emitter.setInterval(500);

		System.out.println("Main Sleeping");
		Thread.sleep(2500);

		System.out.println("Disabling Monitor");
		monitor.disable();

		System.out.println("Main Sleeping");
		Thread.sleep(2500);

		System.out.println("Main Stopping");
		emitter.stop();
	}
}

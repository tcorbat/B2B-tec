package case2;


public class Trip {
	private int distance;
	private MeansOfTransport meansOfTransport;

	public Trip(int distance, MeansOfTransport meansOfTransport) {
		this.distance = distance;
		this.meansOfTransport = meansOfTransport;
	}

	public int duration() {
		int speed = speed();
		return distance / speed;
	}

	private int speed() {
		switch (meansOfTransport) {
		case Bicycle:
			return 20;
		case Car:
			return 80;
		case Walk:
			return 5;
		default:
			throw new IllegalArgumentException("Unknown means of transport: " + meansOfTransport);
		}
	}
}

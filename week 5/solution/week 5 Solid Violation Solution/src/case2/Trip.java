package case2;

import case2.transport.MeansOfTransport;

public class Trip {
	private int distance;
	private MeansOfTransport meansOfTransport;

	public Trip(int distance, MeansOfTransport meansOfTransport) {
		this.distance = distance;
		this.meansOfTransport = meansOfTransport;
	}

	public int duration() {
		var speed = meansOfTransport.speed();
		return distance / speed;
	}

}

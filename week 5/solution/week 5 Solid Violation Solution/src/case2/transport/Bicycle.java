package case2.transport;

public class Bicycle implements MeansOfTransport {

	private static final int BICYCLE_SPEED = 20;

	@Override
	public int speed() {
		return BICYCLE_SPEED;
	}

}

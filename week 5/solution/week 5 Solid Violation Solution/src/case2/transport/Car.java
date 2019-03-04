package case2.transport;

public class Car implements MeansOfTransport {

	private static final int CAR_SPEED = 80;

	@Override
	public int speed() {
		return CAR_SPEED;
	}

}

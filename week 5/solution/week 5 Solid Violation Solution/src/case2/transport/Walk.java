package case2.transport;

public class Walk implements MeansOfTransport {

	private static final int WALKING_SPEED = 5;

	@Override
	public int speed() {
		return WALKING_SPEED;
	}

}

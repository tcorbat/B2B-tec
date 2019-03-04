package case1;

public class Penguin implements Bird {

	@Override
	public void layEgg() {
		System.out.println("Penguin lays an egg");
	}

	@Override
	public void fly() {
		throw new UnsupportedOperationException();
	}

}

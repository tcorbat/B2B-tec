package case1;

public class Pigeon implements Bird {

	@Override
	public void layEgg() {
		System.out.println("Pigeon lays an egg");
	}

	@Override
	public void fly() {
		System.out.println("Pigeon flies away");
	}

}

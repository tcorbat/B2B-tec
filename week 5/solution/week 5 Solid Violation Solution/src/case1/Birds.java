package case1;

public class Birds {

	private static void doBirdStuff(Bird bird) {
		bird.layEgg();
	}

	private static void doFlyingBirdStuff(FlyingBird flyingBird) {
		flyingBird.layEgg();
		flyingBird.fly();
	}

	public static void main(String[] args) {
		var pigeon = new Pigeon();
		doFlyingBirdStuff(pigeon);

		var penguin = new Penguin();
		doBirdStuff(penguin);
	}
}

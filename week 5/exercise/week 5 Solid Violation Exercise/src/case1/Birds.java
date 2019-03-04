package case1;

public class Birds {

	private static void doBirdStuff(Bird bird) {
		bird.layEgg();
		bird.fly();
	}

	public static void main(String[] args) {
		var pigeon = new Pigeon();
		doBirdStuff(pigeon);

		var penguin = new Penguin();
		doBirdStuff(penguin);
	}
}

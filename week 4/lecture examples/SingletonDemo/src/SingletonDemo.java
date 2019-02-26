
public class SingletonDemo {
	private int myVariable = 42;

	public int myMethod(int input) {
		var counter = GlobalCounter.getInstance();
		return input + myVariable + counter.getAndIncrementValue();
	}

	public static void main(String[] args) {
		var input = 5;
		var demo = new SingletonDemo();
		System.out.println(demo.myMethod(input));
		System.out.println(demo.myMethod(input));
	}
}

package case5.gui;

public class CounterDisplay implements case5.problemdomain.ICounterDisplay {
	public void showValue(int value) {
		System.out.println("Counter Display: value is " + value);
	}
}

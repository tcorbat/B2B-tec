package case5.problemdomain;

import java.io.Serializable;

import case5.gui.CounterDisplay;

public class Counter implements Serializable {
	private static final long serialVersionUID = -5261193331424340818L;

	private int value = 0;
	
	public void incrementAndShow(CounterDisplay display) {
		value++;
		display.showValue(value);
	}
}

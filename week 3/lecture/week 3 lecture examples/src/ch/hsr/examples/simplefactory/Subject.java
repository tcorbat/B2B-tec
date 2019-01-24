package ch.hsr.examples.simplefactory;

public class Subject {
	private final String key;
	
	Subject(String key) {
		this.key = key;
	}
	
	public String keyOf() {
		return key;
	}
}

package ch.hsr.examples.simplefactory;

public class SubjectFactory {
	private SubjectFactory() { }
	
	public static Subject create(String key) {
		if (key != null) {
			return new Subject(key);
		} else {
			return new UnknownSubject();
		}
	}
}

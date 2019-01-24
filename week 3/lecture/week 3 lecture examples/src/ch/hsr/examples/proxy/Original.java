package ch.hsr.examples.proxy;

public class Original extends AbstractOriginal {
	public Original() {
		
	}
	
	@Override
	public Object doAction() {
		return new Object(); // retrieve data from server
	}
}

package ch.hsr.examples.mediator.ui;

import ch.hsr.examples.observer.Observer;

public interface Form {
	public String getName();
	public void setName(String name);
	
	public String getStreet();
	public void setStreet(String street);

	public String getZIP();
	public void setZIP(String zip);
	
	public void attach(Observer observer);
}

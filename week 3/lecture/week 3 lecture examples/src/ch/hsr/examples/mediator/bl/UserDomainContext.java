package ch.hsr.examples.mediator.bl;

import ch.hsr.examples.observer.Subject;

public class UserDomainContext extends Subject implements DomainContext {
	public String getName() {
		return "";
	}
	public void setName(String name) {
	}
	
	public String getStreet() {
		return "";
	}
	public void setStreet(String street) {
	}

	public String getZIP() {
		return "";
	}
	public void setZIP(String zip) {
	}
}

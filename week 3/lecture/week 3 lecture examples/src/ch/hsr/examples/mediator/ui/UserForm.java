package ch.hsr.examples.mediator.ui;

import ch.hsr.examples.observer.Subject;

public class UserForm extends Subject implements Form {
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

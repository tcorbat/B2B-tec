package ch.hsr.examples.mediator;

import ch.hsr.examples.mediator.bl.DomainContext;
import ch.hsr.examples.mediator.ui.Form;

public class Mediator {
	
	private DomainContext domain;
	private Form userForm;
	
	public Mediator(DomainContext businessData, Form userFormular) {
		domain = businessData;
		userForm = userFormular;
		
		domain.attach((Object eventData) -> {
				userForm.setName(domain.getName());
				userForm.setStreet(domain.getStreet());
				userForm.setZIP(domain.getZIP());
			});
		userForm.attach((Object eventData) -> {
				domain.setName(userForm.getName());
				domain.setStreet(userForm.getStreet());
				domain.setZIP(userForm.getZIP());
			});
	}

}

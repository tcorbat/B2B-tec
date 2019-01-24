package ch.hsr.examples.mediator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ch.hsr.examples.mediator.Mediator;
import ch.hsr.examples.mediator.bl.DomainContext;
import ch.hsr.examples.mediator.bl.UserDomainContext;
import ch.hsr.examples.mediator.ui.Form;
import ch.hsr.examples.mediator.ui.UserForm;

public class MediatorTest {

	@Test
	public void test_mediator_setup() {
		Form userFormMock = new UserForm();  // new Moq<IUserForm>(); ..
		DomainContext businessCtxMock = new UserDomainContext(); // new Moq<IUserBusinessContext>(); ..
		
		Mediator m = new Mediator(businessCtxMock, userFormMock);
		// asserts here
	}
}

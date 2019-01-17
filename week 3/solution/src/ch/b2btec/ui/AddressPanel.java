package ch.b2btec.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Consumer;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ch.b2btec.ui.generated.AddressPanelBase;
import ch.b2btec.ui.models.AddressModel;
import ch.b2btec.ui.models.LoginModel.Property;

public class AddressPanel extends AddressPanelBase implements PropertyChangeListener {

	private static final long serialVersionUID = 51854768010853903L;

	private static final class InputEventDelegator implements DocumentListener {

		private final Consumer<DocumentEvent> inputHandler;

		public InputEventDelegator(Consumer<DocumentEvent> inputHandler) {
			assert (inputHandler != null);
			this.inputHandler = inputHandler;
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			inputHandler.accept(e);
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			inputHandler.accept(e);
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			inputHandler.accept(e);
		}
	}

	private final AddressModel model;


	public AddressPanel(AddressModel model) {
		this.model = model;
		InputEventDelegator inputHandler = new InputEventDelegator(this::updateInput);
		model.addPropertyChangeListener(this);
		streetField.getDocument().addDocumentListener(inputHandler);
	}

	private void updateInput(DocumentEvent event) {
		model.setStreetName(streetField.getText());
		model.setHouseNumber(Integer.parseInt(houseNumberField.getText()));
		model.setZipCode(Integer.parseInt(zipCodeField.getText()));
		model.setCity(cityField.getText());
		model.setCountry(countryField.getText());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Property property = Property.valueOf(evt.getPropertyName());
		switch (property) {
		case Message:
			lblMessage.setText(model.getMessage());
			break;
		case Username:
			txtUsername.setText(model.getUsername());
			break;
		case Password:
			passwordField.setText(model.getPassword());
			break;
		}
	}
}

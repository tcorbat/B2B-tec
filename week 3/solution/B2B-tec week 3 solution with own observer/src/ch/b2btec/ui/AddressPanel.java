package ch.b2btec.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Consumer;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ch.b2btec.ui.generated.AddressPanelBase;
import ch.b2btec.ui.models.AddressModel;
import ch.b2btec.ui.models.AddressModel.Property;

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
		streetField.setText(model.getStreetName());
		houseNumberField.setText(model.getHouseNumber());
		zipCodeField.setText(model.getZipCode());
		cityField.setText(model.getCity());
		countryField.setText(model.getCountry());

		InputEventDelegator inputHandler = new InputEventDelegator(this::updateInput);
		streetField.getDocument().addDocumentListener(inputHandler);
		houseNumberField.getDocument().addDocumentListener(inputHandler);
		zipCodeField.getDocument().addDocumentListener(inputHandler);
		cityField.getDocument().addDocumentListener(inputHandler);
		countryField.getDocument().addDocumentListener(inputHandler);
		model.addPropertyChangeListener(this);
		disableFields();
	}

	private void disableFields() {
		streetField.setEditable(false);
		houseNumberField.setEditable(false);
		zipCodeField.setEditable(false);
		cityField.setEditable(false);
		countryField.setEditable(false);
	}

	private void updateInput(DocumentEvent event) {
		model.removePropertyChangeListener(this);
		model.setStreetName(streetField.getText());
		model.setHouseNumber(houseNumberField.getText());
		model.setZipCode(zipCodeField.getText());
		model.setCity(cityField.getText());
		model.setCountry(countryField.getText());
		model.addPropertyChangeListener(this);
		messageLabel.setText(model.getMessage());
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Property property = Property.valueOf(evt.getPropertyName());
		switch (property) {
		case Message:
			messageLabel.setText(model.getMessage());
			break;
		case StreetName:
			streetField.setText(model.getStreetName());
			break;
		case HouseNumber:
			houseNumberField.setText(model.getHouseNumber());
			break;
		case ZipCode:
			zipCodeField.setText(model.getZipCode());
			break;
		case City:
			cityField.setText(model.getCity());
			break;
		case Country:
			countryField.setText(model.getCountry());
			break;
		}
	}
}

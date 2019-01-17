package ch.b2btec.ui.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ObservableModel {

	protected final PropertyChangeSupport observable = new PropertyChangeSupport(this);

	public ObservableModel() {
		super();
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		observable.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		observable.removePropertyChangeListener(listener);
	}

}
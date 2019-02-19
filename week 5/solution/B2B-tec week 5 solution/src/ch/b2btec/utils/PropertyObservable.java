package ch.b2btec.utils;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PropertyObservable {

	protected final PropertyChangeSupport observable = new PropertyChangeSupport(this);

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		observable.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		observable.removePropertyChangeListener(listener);
	}

}
package ui;
import bl.DomainModel;

//TODO: Implement the DomainModelObserver interface
public class UserInterface {
	private DomainModel model;

	public UserInterface(DomainModel model) {
		this.model = model;
		// TODO: Register as DomainModel observer
	}

	// TODO: Call if model notifies change
	private void updateWithDomainModelData(String newData) {
		System.out.println("UI: " + newData);
	}
}

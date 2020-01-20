package ui;
import bl.DomainModel;
import infrastructure.ModelObserver;

public class UserInterface implements ModelObserver {
	private DomainModel model;

	public UserInterface(DomainModel model) {
		this.model = model;
		model.addObserver(this);
	}

	private void updateWithDomainModelData(String newData) {
		System.out.println("UI: " + newData);
	}

	@Override
	public void modelHasChanged() {
		var newData = model.getData();
		updateWithDomainModelData(newData);
	}
}

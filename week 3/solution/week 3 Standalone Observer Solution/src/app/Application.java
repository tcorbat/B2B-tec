package app;
import bl.DomainModel;
import ui.UserInterface;

public class Application {

	public static void main(String[] args) {
		var model = new DomainModel();
		var ui = new UserInterface(model);
		model.setData("data");
	}
}

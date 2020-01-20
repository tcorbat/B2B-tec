package bl;

//TODO: Make DomainModel a ModelObservable and implement the required method
public class DomainModel {
	private String data = "no data";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
		// TODO: Invoke notification of observers
	}

}

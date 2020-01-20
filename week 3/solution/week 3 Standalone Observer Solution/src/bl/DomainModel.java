package bl;

import infrastructure.ModelObservable;

public class DomainModel extends ModelObservable {
	private String data = "no data";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
		publishChange();
	}

}

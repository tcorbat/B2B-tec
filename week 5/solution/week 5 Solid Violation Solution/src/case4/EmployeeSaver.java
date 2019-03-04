package case4;

import case4.infrastructure.Database;

public class EmployeeSaver {

	public void store(EmployeeData employee) {
		Database.storeEmployee(employee);
	}

	public static EmployeeData load(int id) {
		return Database.loadEmployee(id);
	}
}

package case4;

import case4.infrastructure.Database;
import case4.infrastructure.TimeSheet;

public class Employee {

	private int wagePerHour;
	private int regularHours;
	private int overtimeHours;
	private int databaseId;

	public int getWagePerHour() {
		return wagePerHour;
	}

	public int getMonthlySalary() {
		return getWagePerHour() * getHoursWorked();
	}

	public TimeSheet getTimeSheet() {
		return new TimeSheet(getHoursWorked());
	}

	public int getDatabaseId() {
		return databaseId;
	}

	private int getHoursWorked() {
		return regularHours + overtimeHours;
	}

	public void store() {
		Database.storeEmployee(this);
	}

	public static Employee load(int id) {
		return Database.loadEmployee(id);
	}
}

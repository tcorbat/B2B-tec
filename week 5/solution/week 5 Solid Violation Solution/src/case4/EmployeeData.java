package case4;

public class EmployeeData {

	private int wagePerHour;
	private int regularHours;
	private int overtimeHours;
	private int databaseId;

	public int getWagePerHour() {
		return wagePerHour;
	}

	public int getDatabaseId() {
		return databaseId;
	}

	public int getHoursWorked() {
		return regularHours + overtimeHours;
	}

}

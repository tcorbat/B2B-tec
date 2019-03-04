package case4;

import case4.infrastructure.TimeSheet;

public class HourReporter {

	public TimeSheet getTimeSheet(EmployeeData employee) {
		return new TimeSheet(employee.getHoursWorked());
	}

}

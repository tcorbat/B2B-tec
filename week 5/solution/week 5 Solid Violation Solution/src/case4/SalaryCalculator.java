package case4;

public class SalaryCalculator {
	public int getMonthlySalary(EmployeeData employee) {
		return employee.getWagePerHour() * employee.getHoursWorked();
	}
}

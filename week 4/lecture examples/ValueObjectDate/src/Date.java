import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Date implements Comparable<Date> {
	private final int day;
	private final Month month;
	private final int year;
	private static final Map<Month, Function<Integer, Integer>> daysOfMonth = new HashMap<>();

	static {
		Function<Integer, Integer> feb = year -> isLeapYear(year) ? 29 : 28;
		Function<Integer, Integer> thirty = year -> 30;
		Function<Integer, Integer> thirtyOne = year -> 31;
		daysOfMonth.put(Month.Jan, thirtyOne);
		daysOfMonth.put(Month.Feb, feb);
		daysOfMonth.put(Month.Mar, thirtyOne);
		daysOfMonth.put(Month.Apr, thirty);
		daysOfMonth.put(Month.May, thirtyOne);
		daysOfMonth.put(Month.Jun, thirty);
		daysOfMonth.put(Month.Jul, thirtyOne);
		daysOfMonth.put(Month.Aug, thirtyOne);
		daysOfMonth.put(Month.Sep, thirty);
		daysOfMonth.put(Month.Oct, thirtyOne);
		daysOfMonth.put(Month.Nov, thirty);
		daysOfMonth.put(Month.Dec, thirtyOne);
	}

	public Date(int day, Month month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		checkDate();
	}

	private static boolean isLeapYear(Integer year) {
		if (year % 400 == 0) {
			return true;
		}
		if (year % 100 == 0) {
			return false;
		}
		return year % 4 == 0;
	}

	private void checkDate() {
		// ... if invalid throw new IllegalArgumentException
	}

	public Date tomorrow() {
		var day = nextDay();
		var month = getMonth();
		var year = getYear();
		if (day == 1) {
			month = month.nextMonth();
			if (month == Month.Jan) {
				year++;
			}
		}
		return new Date(day, month, year);
	}

	private int getYear() {
		return year;
	}

	private Month getMonth() {
		return month;
	}

	private int nextDay() {
		return day % daysInMonth() + 1;
	}

	public int daysInMonth() {
		return daysOfMonth.get(month).apply(year);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		return year == other.year;
	}

	@Override
	public int compareTo(Date o) {
		if (year != o.year) {
			return year - o.year;
		}
		if (month != o.month) {
			return month.ordinal() - o.month.ordinal();
		}
		return day - o.day;
	}
}
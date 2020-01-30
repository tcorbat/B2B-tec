
public class Date implements Comparable<Date> {
	private final int day;
	private final Month month;
	private final int year;

	public Date(int day, Month month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
		checkDate();
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
		return day + 1;
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
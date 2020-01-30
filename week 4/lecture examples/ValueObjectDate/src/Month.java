
public enum Month {
	Jan, Feb, Mar, Apr, Mai, Jun, Jul, Aug, Sep, Oct, Nov, Dec;

	public Month nextMonth() {
		return this == Month.Dec ? Month.Jan : Month.values()[ordinal() + 1];
	}
}

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderRepository {
	private List<Order> allOrders = new ArrayList<>();

	public Collection<Order> findOrders(String from, String to) {
		return allOrders.stream().filter(new Before(to)).filter(new After(from)).collect(Collectors.toList());
	}

	private static class Before implements Predicate<Order> {
		private final String date;
		public Before(String date) {
			this.date = date;
		}

		@Override
		public boolean test(Order t) {
			return date.compareTo(t.getDate()) > 1;
		}
	}

	private static class After implements Predicate<Order> {
		private final String date;

		public After(String date) {
			this.date = date;
		}

		@Override
		public boolean test(Order t) {
			return date.compareTo(t.getDate()) < 1;
		}
	}
}

import ch.b2btec.bl.domain.Address;
import ch.b2btec.bl.domain.Credentials;
import ch.b2btec.bl.domain.Customer;
import ch.b2btec.bl.domain.Profile;
import ch.b2btec.bl.services.impl.UserManagementService;

public class HardcodedUserDataBuilder {


	public static void main(String[] args) throws Exception {
		UserManagementService userManagement = new UserManagementService();

		userManagement.addCustomer(createAlBorland());
		userManagement.addCustomer(createSamwiseGamgee());

		new DataWriter("users.json").write(userManagement);
	}

	private static Customer createSamwiseGamgee() {
		var deliveryAddress = new Address("Bagshot Row", 15, 1337, "Hobbiton", "Shire");
		var billingAddress = new Address("Bag End", 3, 1337, "Hobbiton", "Shire");
		var credentials = new Credentials("sam", "taters");
		var profile = new Profile(credentials, deliveryAddress, billingAddress);
		var customer = new Customer("Samwise Gamgee", 99, profile);
		return customer;
	}

	private static Customer createAlBorland() {
		var address = new Address("Toolstreet", 5, 98765, "Michigan", "USA");
		var credentials = new Credentials("al", "flanel");
		var profile = new Profile(credentials, address);
		var customer = new Customer("Al Borland", 555, profile);
		return customer;
	}

}

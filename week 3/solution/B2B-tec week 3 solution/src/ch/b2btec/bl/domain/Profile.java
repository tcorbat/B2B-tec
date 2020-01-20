package ch.b2btec.bl.domain;

public class Profile {
	private final Credentials credentials;
	private final Address deliveryAddress;
	private final Address billingAddress;

	public Profile(Credentials credentials, Address deliveryAddress, Address billingAddress) {
		this.credentials = credentials;
		this.deliveryAddress = deliveryAddress;
		this.billingAddress = billingAddress;
	}

	public Profile(Credentials defaultCredentials, Address defaultAddress) {
		this(defaultCredentials, defaultAddress, defaultAddress);
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}
}

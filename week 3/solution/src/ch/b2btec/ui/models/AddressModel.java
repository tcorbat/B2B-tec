package ch.b2btec.ui.models;

import ch.b2btec.bl.domain.Address;
import ch.b2btec.utils.PropertyObservable;
import ch.b2btec.utils.StringUtils;

public class AddressModel extends PropertyObservable {
	public enum Property {
		StreetName, HouseNumber, ZipCode, City, Country, Message
	}

	private String streetName;
	private String houseNumber;
	private String zipCode;
	private String city;
	private String country;
	private String message;

	public AddressModel(Address address) {
		streetName = address.getStreetName();
		houseNumber = Integer.toString(address.getHouseNumber());
		zipCode = Integer.toString(address.getZipCode());
		city = address.getCity();
		country = address.getCountry();
	}

	public void setStreetName(String streetName) {
		var currentStreetName = this.streetName;
		this.streetName = streetName;
		observable.firePropertyChange(Property.StreetName.toString(), currentStreetName, streetName);
		verifyContent();
	}

	public void setHouseNumber(String houseNumber) {
		var currentHouseNumber = this.houseNumber;
		this.houseNumber = houseNumber;
		observable.firePropertyChange(Property.HouseNumber.toString(), currentHouseNumber, houseNumber);
		verifyContent();
	}

	public void setZipCode(String zipCode) {
		var currentZipCode = this.zipCode;
		this.zipCode = zipCode;
		observable.firePropertyChange(Property.ZipCode.toString(), currentZipCode, zipCode);
		verifyContent();
	}

	public void setCity(String city) {
		var currentCity = this.city;
		this.city = city;
		observable.firePropertyChange(Property.City.toString(), currentCity, city);
		verifyContent();
	}

	public void setCountry(String country) {
		var currentCountry = this.country;
		this.country = country;
		observable.firePropertyChange(Property.Country.toString(), currentCountry, country);
		verifyContent();
	}

	public String getMessage() {
		return message;
	}

	private void verifyContent() {
		var message = "";
		if (streetName.isBlank()) {
			message = "Street name must not be blank";
		} else if (!StringUtils.containsOnlyDigits(houseNumber)) {
			message = "House number must not be empty and can only contain digits";
		} else if (!StringUtils.containsOnlyDigits(zipCode)) {
			message = "Zip code must not be empty and can only contain digits";
		} else if (city.isBlank()) {
			message = "City must not be blank";
		} else if (country.isBlank()) {
			message = "Country must not be blank";
		}
		setMessage(message);
	}

	private void setMessage(String message) {
		var currentMessage = this.message;
		this.message = message;
		observable.firePropertyChange(Property.Message.toString(), currentMessage, message);
	}

	public String getStreetName() {
		return streetName;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}
}

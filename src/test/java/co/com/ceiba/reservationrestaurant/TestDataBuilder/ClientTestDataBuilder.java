package co.com.ceiba.reservationrestaurant.TestDataBuilder;

import co.com.ceiba.reservationrestaurant.dominio.Client;

public class ClientTestDataBuilder {

	
	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";

	private String firstName;
	private String lastName;
	private String Email;
	private String phoneNumber;
	
	

	public ClientTestDataBuilder() {
		this.firstName = FIRSTNAME;
		this.lastName = LASTNAME;
		this.Email = EMAIL;
		this.phoneNumber = PHONENUMBER;
	}

	public ClientTestDataBuilder whitFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public ClientTestDataBuilder whitLastName(String lastName) {
		this.lastName = lastName;
		return this;

	}

	public ClientTestDataBuilder whiteEmail(String email) {
		this.Email = email;
		return this;
	}

	public ClientTestDataBuilder whitePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;

	}

	public Client build() {
		return new Client(firstName, lastName, Email, phoneNumber);
}

}

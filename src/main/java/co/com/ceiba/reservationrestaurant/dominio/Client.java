package co.com.ceiba.reservationrestaurant.dominio;

import co.com.ceiba.reservationrestaurant.dominio.strategies.ArgumentsValidator;

public class Client {

	private static final String EL_NOMBRE_ES_OBLIGATORIO = "EL NOMBRE ES OBLIGATORIO";
	private static final String EL_APELLIDO_ES_OBLIGATORIO = "EL APELLIDO ES OBLIGATORIO";
	private static final String EL_EMAIL_ES_OBLIGATORIO = "EL EMAIL ES OBLIGATORIO";

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	public Client(String firstName, String lastName, String email, String phoneNumber) {

		ArgumentsValidator.restrictionForNull(firstName, EL_NOMBRE_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForValueEmpty(firstName, EL_NOMBRE_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForNull(lastName, EL_APELLIDO_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForValueEmpty(lastName, EL_APELLIDO_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForNull(email, EL_EMAIL_ES_OBLIGATORIO);
		ArgumentsValidator.restrictionForValueEmpty(email, EL_EMAIL_ES_OBLIGATORIO);

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

}

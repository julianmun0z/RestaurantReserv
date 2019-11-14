package co.com.ceiba.reservationrestaurant.dominio;

import java.util.Calendar;
import co.com.ceiba.reservationrestaurant.dominio.strategies.ArgumentsValidator;

public class Reservation {

	private static final String LA_FECHA_ES_OBLIGATORIA = "LA FECHA ES OBLIGATORIA";
	private static final String EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO = "EL NUMERO DE PERSONAS PARA LA RESERVA ES OBLIGATORIO";

	private int idReservation;
	private Calendar reservationDate;
	private int numberPeople;
	private boolean decor;
	private Bill bill;
	private Client client;

	public Reservation(int idReservation, Calendar reservationDate, int numberPeople, boolean decor, Client client) {
		
		ArgumentsValidator.restrictionForNull(reservationDate, LA_FECHA_ES_OBLIGATORIA);
		ArgumentsValidator.restrictionForValueZero(numberPeople, EL_NUMERO_DE_PERSONAS_PARA_LA_RESERVA_ES_OBLIGATORIO);
		
		this.idReservation = idReservation;
		this.reservationDate = reservationDate;
		this.numberPeople = numberPeople;
		this.decor = decor;
		this.client = client;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	public int getIdReservation() {
		return idReservation;
	}

//	public void setIdReservation(int idReservation) {
//		this.idReservation = idReservation;
//	}

	public Client getClient() {
		return client;
	}

//	public void setClient(Client client) {
//		this.client = client;
//	}

	public void setReservationDate(Calendar reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Calendar getReservationDate() {
		return reservationDate;
	}

	public int getNumberPeople() {
		return numberPeople;
	}

//	public void setNumberPeople(int numberPeople) {
//		this.numberPeople = numberPeople;
//	}

//	public void setDecor(boolean decor) {
//		this.decor = decor;
//	}

	public boolean isDecor() {
		return decor;
	}

	Calendar currentDate = Calendar.getInstance();
	
	public Calendar getCurrentDate() {
		return currentDate;
	}

//	public void setCurrentDate(Calendar currentDate) {
//		this.currentDate = currentDate;
//	}
}

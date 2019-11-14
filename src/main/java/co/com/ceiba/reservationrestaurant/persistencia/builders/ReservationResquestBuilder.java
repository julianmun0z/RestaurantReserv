package co.com.ceiba.reservationrestaurant.persistencia.builders;

import org.springframework.context.annotation.Configuration;
import co.com.ceiba.reservationrestaurant.dominio.Bill;
import co.com.ceiba.reservationrestaurant.dominio.Client;
import co.com.ceiba.reservationrestaurant.dominio.Reservation;

import co.com.ceiba.reservationrestaurant.aplicacion.dto.ReservationRequest;

@Configuration
public class ReservationResquestBuilder {

	public Reservation divisionReservationRequest(ReservationRequest reservationRequest) {

		Client client = new Client(reservationRequest.getFirstName(), reservationRequest.getLastName(),
				reservationRequest.getEmail(), reservationRequest.getPhoneNumber());

		Reservation reservation = new Reservation(reservationRequest.getId(), reservationRequest.getReservationDate(),
				reservationRequest.getNumberPeople(), reservationRequest.isDecor(), client);
		
		Bill bill = new Bill(reservation);

		reservation.setBill(bill);
		
		return reservation;
	}

	public ReservationRequest getReservartionObjectReservationRequest(Reservation reservation) {

		ReservationRequest reservationRequest = new ReservationRequest();

		reservationRequest.setId(reservation.getIdReservation());
		reservationRequest.setReservationDate(reservation.getReservationDate());
		reservationRequest.setDecor(reservation.isDecor());
		reservationRequest.setNumberPeople(reservation.getNumberPeople());
		reservationRequest.setFirstName(reservation.getClient().getFirstName());
		reservationRequest.setLastName(reservation.getClient().getLastName());
		reservationRequest.setEmail(reservation.getClient().getEmail());
		reservationRequest.setPhoneNumber(reservation.getClient().getPhoneNumber());

		return reservationRequest;
	}

}

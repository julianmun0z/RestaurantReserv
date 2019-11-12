package co.com.ceiba.reservationrestaurant.persistencia.builders;

import org.springframework.context.annotation.Configuration;
import co.com.ceiba.reservationrestaurant.dominio.Bill;
import co.com.ceiba.reservationrestaurant.dominio.Client;
import co.com.ceiba.reservationrestaurant.dominio.Reservation;

import co.com.ceiba.reservationrestaurant.dto.ReservationRequest;

@Configuration
public class ReservationResquestBuilder {

	public Reservation divisionReservationRequest(ReservationRequest reservationRequest) {

		Bill bill = new Bill(0, 0, 0);

		bill.getCaculatePriceAndDiscounts(reservationRequest, bill);

		Client client = new Client( reservationRequest.getFirstName(), reservationRequest.getLastName(),
				reservationRequest.getEmail(), reservationRequest.getPhoneNumber());
		
		Reservation reservation = new Reservation(reservationRequest.getId(), reservationRequest.getReservationDate(),
				reservationRequest.getNumberPeople(), reservationRequest.isDecor(), bill, client);

		return reservation;
	}
	
	public ReservationRequest getClientObjectReservationRequest(Reservation reservation) {
		
		ReservationRequest reservationRequest = new ReservationRequest();
		
		reservationRequest.setId(reservation.getIdReservation());
		reservationRequest.setFirstName(reservation.getClient().getFirstName());
		reservationRequest.setLastName(reservation.getClient().getLastName());
		reservationRequest.setEmail(reservation.getClient().getEmail());
		reservationRequest.setPhoneNumber(reservation.getClient().getPhoneNumber());
		reservationRequest.setReservationDate(reservation.getReservationDate());
		reservationRequest.setDecor(reservation.isDecor());
		reservationRequest.setNumberPeople(reservation.getNumberPeople());
		
		return reservationRequest;
	}

}

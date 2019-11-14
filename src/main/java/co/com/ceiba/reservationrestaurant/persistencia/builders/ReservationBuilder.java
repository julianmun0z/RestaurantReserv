package co.com.ceiba.reservationrestaurant.persistencia.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.reservationrestaurant.dominio.Bill;
import co.com.ceiba.reservationrestaurant.dominio.Client;
import co.com.ceiba.reservationrestaurant.dominio.Reservation;
import co.com.ceiba.reservationrestaurant.persistencia.entities.BillEntity;
import co.com.ceiba.reservationrestaurant.persistencia.entities.ClientEntity;
import co.com.ceiba.reservationrestaurant.persistencia.entities.ReservationEntity;

@Configuration
public class ReservationBuilder {

	@Autowired
	BillBuilder billBuilder;

	@Autowired
	ClientBuilder ClientBuilder;

	public ReservationEntity convertReservationToReservationEntity(Reservation reservation) {

		ReservationEntity reservationEntity = new ReservationEntity();

		BillEntity billEntity = new BillBuilder().converBillToBillEntity(reservation.getBill());
		ClientEntity clientEntity = new ClientBuilder().convertClientToRClientEntity(reservation.getClient());

		reservationEntity.setIdReservation(reservation.getIdReservation());
		reservationEntity.setReservationDate(reservation.getReservationDate());
		reservationEntity.setNumberPeople(reservation.getNumberPeople());
		reservationEntity.setDecor(reservation.isDecor());
		reservationEntity.setBillEntity(billEntity);
		reservationEntity.setClientEntity(clientEntity);
		return reservationEntity;
	}

	public Reservation convertReservationEntityToReservation(ReservationEntity reservationEntity) {

		Bill bill = new BillBuilder().convertBillEntityToBill(reservationEntity.getBillEntity());
		Client client = new ClientBuilder().convertClientEntityToClient(reservationEntity.getClientEntity());

		Reservation reservation = new Reservation(reservationEntity.getIdReservation(),
				reservationEntity.getReservationDate(), reservationEntity.getNumberPeople(),
				reservationEntity.isDecor(), client);

		reservation.setBill(bill);

		return reservation;
	}

}

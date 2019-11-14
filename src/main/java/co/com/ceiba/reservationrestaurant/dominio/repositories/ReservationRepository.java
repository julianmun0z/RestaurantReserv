package co.com.ceiba.reservationrestaurant.dominio.repositories;

import java.util.List;

import co.com.ceiba.reservationrestaurant.dominio.Reservation;

public interface ReservationRepository {

	public List<Reservation> getReservations();

	public Reservation getReservationById(int id);
}

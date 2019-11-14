package co.com.ceiba.reservationrestaurant.dominio.repositories;

import java.util.List;

import co.com.ceiba.reservationrestaurant.aplicacion.dto.ReservationRequest;

public interface ReservationRequestRepository {

	public List<ReservationRequest> getReservationRequests();

	public void addReservationRequest(ReservationRequest reservationRequest);

	public ReservationRequest ReservationRequestById(int id);

	public void editReservationRequest(ReservationRequest reservationRequest);

	public ReservationRequest deleteReservationRequest(int id);
}

package co.com.ceiba.reservationrestaurant.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.reservationrestaurant.dominio.Reservation;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ReservationBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.entities.ReservationEntity;
import co.com.ceiba.reservationrestaurant.persistencia.repositories.ReservationRepository;

@Repository
@Transactional
public class ReservationDao {
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ReservationBuilder reservationBuilder;
	
	public List<Reservation> getReservationList() {
		List<Reservation> reservations = new ArrayList<>();
		List<ReservationEntity> entities = reservationRepository.findAll();
		for (ReservationEntity reservationEntity : entities) {
			Reservation reservation = reservationBuilder.convertReservationEntityToReservation(reservationEntity);
	 		reservations.add(reservation);
		}
		return reservations;
	} 

	public Reservation getReservationId(int id) {
		ReservationEntity reservationEntity = reservationRepository.findById(id);
		Reservation reservation = reservationBuilder.convertReservationEntityToReservation(reservationEntity);
		return reservation;
	}
}

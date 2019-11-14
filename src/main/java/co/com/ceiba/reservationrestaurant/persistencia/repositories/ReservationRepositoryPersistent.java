package co.com.ceiba.reservationrestaurant.persistencia.repositories;

import java.util.List;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.reservationrestaurant.dominio.Reservation;
import co.com.ceiba.reservationrestaurant.dominio.repositories.ReservationRepository;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ReservationBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.entities.ReservationEntity;
import co.com.ceiba.reservationrestaurant.persistencia.dao.ReservationDao;

@Service
public class ReservationRepositoryPersistent implements ReservationRepository{

	
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ReservationDao reservationDao;
	
	@Autowired
	ReservationBuilder reservationBuilder;

	@Override
	public List<Reservation> getReservations() {
		List<Reservation> reservations = new ArrayList<>();
		List<ReservationEntity> entities = reservationDao.findAll();
		for (ReservationEntity reservationEntity : entities) {
			Reservation reservation = reservationBuilder.convertReservationEntityToReservation(reservationEntity);
	 		reservations.add(reservation);
		}
		return reservations;
	}

	@Override
	public Reservation getReservationById(int id) {
		ReservationEntity reservationEntity = reservationDao.findById(id);
		Reservation reservation = reservationBuilder.convertReservationEntityToReservation(reservationEntity);
		return reservation;
	}
	
}

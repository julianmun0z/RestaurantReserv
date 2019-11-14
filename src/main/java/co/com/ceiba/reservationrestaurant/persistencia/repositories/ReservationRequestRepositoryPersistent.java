package co.com.ceiba.reservationrestaurant.persistencia.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.reservationrestaurant.dominio.Reservation;
import co.com.ceiba.reservationrestaurant.dominio.repositories.ReservationRequestRepository;
import co.com.ceiba.reservationrestaurant.aplicacion.dto.ReservationRequest;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ClientBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ReservationBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ReservationResquestBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.entities.ReservationEntity;
import co.com.ceiba.reservationrestaurant.persistencia.dao.BillDao;
import co.com.ceiba.reservationrestaurant.persistencia.dao.ClientDao;
import co.com.ceiba.reservationrestaurant.persistencia.dao.ReservationDao;

@Service
public class ReservationRequestRepositoryPersistent implements ReservationRequestRepository {

	@Autowired
	ClientDao clientRepository;

	@Autowired
	BillDao billRepository;

	@Autowired
	ReservationResquestBuilder reservationResquestBuilder;

	@Autowired
	ReservationBuilder reservationBuilder;

	@Autowired
	ClientBuilder clientBuilder;



	@Autowired
	ReservationDao reservationDao;

	@Override
	public List<ReservationRequest> getReservationRequests() {
		List<ReservationRequest> requests = new ArrayList<>();
		List<Reservation> reservations = new ArrayList<>();
		List<ReservationEntity> entities = reservationDao.findAll();

		for (ReservationEntity reservationEntity : entities) {
			Reservation reservationDto = reservationBuilder.convertReservationEntityToReservation(reservationEntity);
			reservations.add(reservationDto);
		}
		for (Reservation reservation : reservations) {
			ReservationRequest request = reservationResquestBuilder
					.getReservartionObjectReservationRequest(reservation);
			requests.add(request);
		}
		return requests;
	}

	@Override
	public void addReservationRequest(ReservationRequest reservationRequest) {
		Reservation reservation = reservationResquestBuilder.divisionReservationRequest(reservationRequest);
		ReservationEntity reservationEntity = reservationBuilder.convertReservationToReservationEntity(reservation);
		clientRepository.save(reservationEntity.getClientEntity());
		reservationDao.save(reservationEntity);
		billRepository.save(reservationEntity.getBillEntity());
	}

	@Override
	public ReservationRequest ReservationRequestById(int id) {
		ReservationEntity reservationEntity = reservationDao.findById(id);
		Reservation reservation = reservationBuilder.convertReservationEntityToReservation(reservationEntity);
		ReservationRequest reservationRequest = reservationResquestBuilder
				.getReservartionObjectReservationRequest(reservation);
		return reservationRequest;
	}

	@Override
	public void editReservationRequest(ReservationRequest reservationRequest) {
		Reservation reservation = reservationResquestBuilder.divisionReservationRequest(reservationRequest);
		ReservationEntity reservationEntity = reservationBuilder.convertReservationToReservationEntity(reservation);
		reservationDao.save(reservationEntity);
	}

	@Override
	public ReservationRequest deleteReservationRequest(int id) {
		ReservationEntity reservationEntity = reservationDao.findById(id);
		Reservation reservation = reservationBuilder.convertReservationEntityToReservation(reservationEntity);
		ReservationRequest reservationRequest = reservationResquestBuilder
				.getReservartionObjectReservationRequest(reservation);
		if (reservation != null) {
			reservationDao.delete(reservationEntity);
		}
		return reservationRequest;
	}

}

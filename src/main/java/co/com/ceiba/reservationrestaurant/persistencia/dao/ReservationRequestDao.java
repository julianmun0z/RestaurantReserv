package co.com.ceiba.reservationrestaurant.persistencia.dao;

import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.ceiba.reservationrestaurant.dominio.Reservation;
import co.com.ceiba.reservationrestaurant.dto.ReservationRequest;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ClientBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ReservationBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ReservationResquestBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.entities.ReservationEntity;
import co.com.ceiba.reservationrestaurant.persistencia.repositories.BillRepository;
import co.com.ceiba.reservationrestaurant.persistencia.repositories.ClientRepository;
import co.com.ceiba.reservationrestaurant.persistencia.repositories.ReservationRepository;

@Repository
@Transactional
public class ReservationRequestDao {

	@Autowired
	BillRepository billRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	ClientBuilder clientBuilder;
	
	@Autowired
	ReservationBuilder reservationBuilder;
	

	@Autowired
	ReservationResquestBuilder reservationResquestBuilder;
	
	public List<ReservationRequest> getListsOfReservationRequests() {	
		List<ReservationRequest> requests = new ArrayList<>();
		List<Reservation> reservations = new ArrayList<>();
		List<ReservationEntity> entities = reservationRepository.findAll();		

		for (ReservationEntity reservationEntity : entities) {
	 		Reservation reservationDto = reservationBuilder.convertReservationEntityToReservation(reservationEntity);
	 		reservations.add(reservationDto);
		}		
		for(Reservation reservation:reservations) {
			ReservationRequest request = reservationResquestBuilder.getClientObjectReservationRequest(reservation);
			requests.add(request);
		}		
	return requests;	
	}
	
	public void saveReservationRequest( Reservation reservation ) {
		ReservationEntity reservationEntity = reservationBuilder.convertReservationToReservationEntity(reservation);
	clientRepository.save(reservationEntity.getClientEntity());
	reservationRepository.save(reservationEntity);
	billRepository.save(reservationEntity.getBillEntity());
	}
	
	public ReservationRequest getReservationRequestById(int id) {
		ReservationEntity reservationEntity = reservationRepository.findById(id);
		Reservation reservation = reservationBuilder.convertReservationEntityToReservation(reservationEntity);
		 ReservationRequest reservationRequest = reservationResquestBuilder.getClientObjectReservationRequest(reservation);
		return reservationRequest;
	}
	
	public void edit(Reservation reservation) {
		ReservationEntity reservationEntity = reservationBuilder.convertReservationToReservationEntity(reservation);
		reservationRepository.save(reservationEntity);
	}
	
	public ReservationRequest delete(int id) { 
		ReservationEntity reservationEntity = reservationRepository.findById(id);
		Reservation reservation = reservationBuilder.convertReservationEntityToReservation(reservationEntity);
		ReservationRequest reservationRequest = reservationResquestBuilder.getClientObjectReservationRequest(reservation);
		if (reservation != null) {
			reservationRepository.delete(reservationEntity);
		}
		return reservationRequest;
	}
}


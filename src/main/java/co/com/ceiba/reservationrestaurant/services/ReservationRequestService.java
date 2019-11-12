package co.com.ceiba.reservationrestaurant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.ceiba.reservationrestaurant.dominio.Reservation;
import co.com.ceiba.reservationrestaurant.dto.ReservationRequest;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ClientBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ReservationBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.builders.ReservationResquestBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.dao.ReservationRequestDao;
import co.com.ceiba.reservationrestaurant.persistencia.repositories.ClientRepository;

@Service
public class ReservationRequestService {
	
	@Autowired
	ReservationResquestBuilder reservationResquestBuilder;

	@Autowired
	ReservationBuilder reservationBuilder;

	@Autowired
	ClientBuilder clientBuilder;
	 
	@Autowired
	ReservationRequestDao reservationRequestDao;
	
	@Autowired
 	ClientRepository clientRepository;
	
		public List<ReservationRequest> getReservationRequests() {		
		return reservationRequestDao.getListsOfReservationRequests();	
		}

	public void addReservationResquest(ReservationRequest reservationRequest) {

		Reservation reservation = reservationResquestBuilder.divisionReservationRequest(reservationRequest);
		reservationRequestDao.saveReservationRequest(reservation); 
	}
 
	public ReservationRequest  ReservationRequestById(int id) {
		return reservationRequestDao.getReservationRequestById(id);
	}

	public void editReservationResquest(ReservationRequest reservationRequest) {
		Reservation reservation = reservationResquestBuilder.divisionReservationRequest(reservationRequest);
		reservationRequestDao.edit(reservation);
	}

	public ReservationRequest deleteReservationRequest(int id) { 
		return reservationRequestDao.delete(id);
	}
}

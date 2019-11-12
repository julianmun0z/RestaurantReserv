package co.com.ceiba.reservationrestaurant.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.ceiba.reservationrestaurant.dominio.Reservation;
import co.com.ceiba.reservationrestaurant.persistencia.dao.ReservationDao;

@Service
public class ReservationService {


	@Autowired
	ReservationDao clientDao;
	
	public List<Reservation> getReservations() {
		return clientDao.getReservationList();
	} 

	public Reservation getReservationById(int id) {
		return clientDao.getReservationId(id);
	}

}

package co.com.ceiba.reservationrestaurant.persistencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.reservationrestaurant.dominio.Reservation;
import co.com.ceiba.reservationrestaurant.persistencia.repositories.ReservationRepositoryPersistent;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping(value = "/client")

public class ReservationController {

	@Autowired
	ReservationRepositoryPersistent reservationService;

	@GetMapping
	public List<Reservation> getClient() {
		return reservationService.getReservations();
	}

	@GetMapping(path = { "/{id}" })
	public Reservation getClientForId(@PathVariable("id") int id) {
		return reservationService.getReservationById(id);
	}

}

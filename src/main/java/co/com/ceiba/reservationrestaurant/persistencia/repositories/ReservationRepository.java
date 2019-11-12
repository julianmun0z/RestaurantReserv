package co.com.ceiba.reservationrestaurant.persistencia.repositories;

import java.util.List;

import org.springframework.data.repository.Repository;

import co.com.ceiba.reservationrestaurant.persistencia.entities.ReservationEntity;

public interface ReservationRepository extends Repository<ReservationEntity, Integer> {

	void save(ReservationEntity reservationEntity);

	List<ReservationEntity> findAll();

	ReservationEntity findById(int id);

	void delete(ReservationEntity reservationEntity);
}

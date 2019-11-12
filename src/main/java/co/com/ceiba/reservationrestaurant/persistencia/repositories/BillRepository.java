package co.com.ceiba.reservationrestaurant.persistencia.repositories;

import org.springframework.data.repository.Repository;

import co.com.ceiba.reservationrestaurant.persistencia.entities.BillEntity;

public interface BillRepository extends Repository<BillEntity, Integer> {

	void save(BillEntity billEntity);
}

package co.com.ceiba.reservationrestaurant.persistencia.dao;

import org.springframework.data.repository.Repository;

import co.com.ceiba.reservationrestaurant.persistencia.entities.BillEntity;

public interface BillDao extends Repository<BillEntity, Integer> {

	void save(BillEntity billEntity);
}

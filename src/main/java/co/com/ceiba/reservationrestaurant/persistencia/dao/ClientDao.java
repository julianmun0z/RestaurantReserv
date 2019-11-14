package co.com.ceiba.reservationrestaurant.persistencia.dao;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.reservationrestaurant.persistencia.entities.ClientEntity;

@Transactional
public interface ClientDao extends Repository<ClientEntity, Integer> {

	void save(ClientEntity clientEntity);

}

package co.com.ceiba.reservationrestaurant.persistencia.repositories;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.reservationrestaurant.persistencia.entities.ClientEntity;

@Transactional
public interface ClientRepository extends Repository<ClientEntity, Integer> {

	void save(ClientEntity clientEntity);

}

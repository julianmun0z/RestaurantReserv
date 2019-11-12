package co.com.ceiba.reservationrestaurant.persistencia.builders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import co.com.ceiba.reservationrestaurant.dominio.Client;
import co.com.ceiba.reservationrestaurant.persistencia.entities.ClientEntity;

@Configuration
public class ClientBuilder {

	@Autowired
	ReservationBuilder reservationBuilder;

	public ClientEntity convertClientToRClientEntity(Client client) {

		ClientEntity clientEntity = new ClientEntity();

		clientEntity.setFirstName(client.getFirstName());
		clientEntity.setLastName(client.getLastName());
		clientEntity.setEmail(client.getEmail());
		clientEntity.setPhoneNumber(client.getPhoneNumber());
		return clientEntity;
	}

	public Client convertClientEntityToClient(ClientEntity clientEntity) {

		Client client = new Client(clientEntity.getFirstName(), clientEntity.getLastName(), clientEntity.getEmail(),
				clientEntity.getPhoneNumber());

		return client;
	}

}

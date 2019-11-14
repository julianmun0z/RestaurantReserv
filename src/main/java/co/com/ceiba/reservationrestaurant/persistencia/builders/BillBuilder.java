package co.com.ceiba.reservationrestaurant.persistencia.builders;

import org.springframework.context.annotation.Configuration;
import co.com.ceiba.reservationrestaurant.dominio.Bill;

import co.com.ceiba.reservationrestaurant.persistencia.entities.BillEntity;

@Configuration
public class BillBuilder {

	public BillEntity converBillToBillEntity(Bill bill) {

		BillEntity billEntity = new BillEntity();
		billEntity.setPrice(bill.getPrice());
		billEntity.setDiscountForPeople(bill.getDiscountForPeople());
		billEntity.setDiscpuntForDays(bill.getDiscpuntForDays());
		return billEntity;
	}

	public Bill convertBillEntityToBill(BillEntity billEntity) {

		Bill bill = new Bill(billEntity.getPrice(), billEntity.getDiscountForPeople(), billEntity.getDiscpuntForDays());
		return bill;
	}
}

package co.com.ceiba.reservationrestaurant.builderTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.com.ceiba.reservationrestaurant.persistencia.builders.ReservationResquestBuilder;
import co.com.ceiba.reservationrestaurant.persistencia.entities.ReservationEntity;
import co.com.ceiba.reservationrestaurant.services.ReservationRequestService;
import co.com.ceiba.reservationrestaurant.dominio.Bill;
import co.com.ceiba.reservationrestaurant.dominio.Client;
import co.com.ceiba.reservationrestaurant.dominio.Reservation;
import co.com.ceiba.reservationrestaurant.dto.ReservationRequest;

public class ReservationResquestBuilderTest { 

	private static final int NUMBER_PEOPLE = 5;
	private static final float PRICE = 350000;

	private static final String FIRSTNAME = "juan";
	private static final String LASTNAME = "gomez";
	private static final String EMAIL = "J@J.COM";
	private static final String PHONENUMBER = "123456789";

	private static final int  EXPECTED_ID = 4; 
	private static final boolean DECOR = true;
	private static final Calendar DATE_WITH_TUESDAY_AND_WENESDAY = new GregorianCalendar(2019, 8, 01);
	private static final Calendar DATE_FOR_DIVISION_DTO  = new GregorianCalendar(
			2019, 9, 12);
	
	@Mock
	private ReservationRequest reservationRequest;

	@Mock
	private Bill bill;
	@Mock
	private Reservation reservation;
	
	@Mock
	private Client client;
	
	@Mock
	private ReservationEntity reservationEntity;

	@Mock
	private ReservationRequestRepositoryPersistent reservationRequestService;

	@InjectMocks
	private ReservationResquestBuilder reservationResquestBuilder;

	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		reservationRequestService = new ReservationRequestRepositoryPersistent();
	}
	
	@Test
	public void divisionReservationRequest() {
		// arrange

		when(reservationRequest.getFirstName()).thenReturn(FIRSTNAME);
		when(reservationRequest.getLastName()).thenReturn(LASTNAME);
		when(reservationRequest.getEmail()).thenReturn(EMAIL);
		when(reservationRequest.getPhoneNumber()).thenReturn(PHONENUMBER);
		when(bill.getPrice()).thenReturn(PRICE);
		when(reservationRequest.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		when(reservationRequest.isDecor()).thenReturn(DECOR);
		when(reservationRequest.getReservationDate())
				.thenReturn(DATE_FOR_DIVISION_DTO);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);


		String expectedFisrtName = FIRSTNAME;
		String expectedLastName = LASTNAME;
		String expectedEmail = EMAIL;
		String expectedPhoneNumber = PHONENUMBER;
		Calendar expectedReservationDate = DATE_FOR_DIVISION_DTO;
		int expecteNumberPeople = NUMBER_PEOPLE;
		boolean expedtedDecor = DECOR;
		// act

		Reservation result = reservationResquestBuilder.divisionReservationRequest(reservationRequest);

		// assert
		assertEquals(expectedFisrtName, result.getClient().getFirstName());
		assertEquals(expectedLastName, result.getClient().getLastName());
		assertEquals(expectedEmail, result.getClient().getEmail());
		assertEquals(expectedPhoneNumber, result.getClient().getPhoneNumber());
		assertEquals(expectedReservationDate, result.getReservationDate());
		assertEquals(expecteNumberPeople, result.getNumberPeople());
		assertEquals(expedtedDecor, result.isDecor());
	}

	@Test
	public void getReservartionObjectReservationRequestTest() {
		//arrange

		when(reservation.getIdReservation()).thenReturn(EXPECTED_ID);
		when(reservation.getNumberPeople()).thenReturn(NUMBER_PEOPLE);
		when(reservation.isDecor()).thenReturn(DECOR);
		when(reservation.getReservationDate())
				.thenReturn(DATE_FOR_DIVISION_DTO);
		when(reservationRequest.getCurrentDate()).thenReturn(DATE_WITH_TUESDAY_AND_WENESDAY);
		when(reservation.getClient()).thenReturn(client);
		when(client.getFirstName()).thenReturn(FIRSTNAME);
		when(client.getLastName()).thenReturn(LASTNAME);
		when(client.getEmail()).thenReturn(EMAIL);
		when(client.getPhoneNumber()).thenReturn(PHONENUMBER);
		
		int expectedid = EXPECTED_ID;
		String expectedFisrtName = FIRSTNAME;
		String expectedLastName = LASTNAME;
		String expectedEmail = EMAIL;
		String expectedPhoneNumber = PHONENUMBER;
		Calendar expectedReservationDate = DATE_FOR_DIVISION_DTO;
		int expecteNumberPeople = NUMBER_PEOPLE;
		boolean expedtedDecor = DECOR;
		
		//act
		ReservationRequest result = reservationResquestBuilder.getReservartionObjectReservationRequest(reservation);
		
		
		// assert
		assertEquals(expectedid, result.getId());
		assertEquals(expectedFisrtName, result.getFirstName());
		assertEquals(expectedLastName, result.getLastName());
		assertEquals(expectedEmail, result.getEmail());
		assertEquals(expectedPhoneNumber, result.getPhoneNumber());
		assertEquals(expectedReservationDate, result.getReservationDate());
		assertEquals(expecteNumberPeople, result.getNumberPeople());
		assertEquals(expedtedDecor, result.isDecor());

	}
	
}

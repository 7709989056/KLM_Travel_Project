package com.akfl.cases.df;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.afkl.cases.df.controller.TravelfareController;
import com.afkl.cases.df.pojo.Fares;
import com.afkl.cases.df.service.TravelfareService;

@RunWith(MockitoJUnitRunner.class)
public class TravelfareControllerTest {
	@InjectMocks
	private TravelfareController travelFareController;

	@Mock
	TravelfareService travelfareService;

	@Before
	public void setup() throws Exception {
	}

	@Test
	public void successReceiveFareOfferTest() throws Exception {
		Mockito.when(travelfareService.retrieveFare(Mockito.any(Fares.class)))
				.thenReturn(Fares.builder().origin("HNL").destination("BBA").currency("EUR").build());
		Fares fares = travelFareController.retriveFareOffer(Fares.builder().origin("HNL").destination("BBA").currency("EUR").build());
		assertEquals("HNL", fares.getOrigin());
	}

	@Test
	public void successAirportListTest() throws Exception {
		List<Fares> faresList = new ArrayList<>();
		Fares fares = Fares.builder().origin("Biju Patnayak Airport India").build();
		faresList.add(fares);
		Mockito.when(travelfareService.getAirportList()).thenReturn(faresList);
		faresList = travelFareController.getAirportList();
		assertEquals("Biju Patnayak Airport India".toString(), faresList.get(0).getOrigin());
	}
}

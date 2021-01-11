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

import com.afkl.cases.df.clientImpl.TravelClientImpl;
import com.afkl.cases.df.pojo.Embedded;
import com.afkl.cases.df.pojo.Fares;
import com.afkl.cases.df.pojo.Locations;
import com.afkl.cases.df.pojo.Parent;
import com.afkl.cases.df.serviceImpl.TravelfareServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TravelServiceImplTest {
	@Mock
	TravelClientImpl travelfareClient;

	@InjectMocks
	private TravelfareServiceImpl travelfareService;

	@Before
	public void setup() throws Exception {
	}

	@Test
	public void successReceiveFareOfferTest() throws Exception {
		Locations location = new Locations();
		location.setDescription("HNL-Honululu");
		Mockito.when(travelfareClient.retrieveFare(Mockito.any(Fares.class)))
				.thenReturn(Fares.builder().origin("HNL").destination("BBA").currency("EUR").build());
		Mockito.when(travelfareClient.getAirportNameByCode(Mockito.any())).thenReturn(location);
		Fares fares = travelfareService
				.retrieveFare(Fares.builder().origin("HNL").destination("BBA").currency("EUR").build());
		assertEquals("HNL-Honululu", fares.getOrigin());
	}

	@Test
	public void successGetAirportListTest() throws Exception {
		Parent parent = new Parent();
		parent.setCode("HNL");
		parent.setDescription("Honululu");
		parent.setParent(new Parent());

		Parent parent1 = new Parent();
		parent.setCode("BBA");
		parent.setDescription("BBA");
		parent.setParent(parent1);

		Locations location = new Locations();
		location.setCode("HNL");
		location.setDescription("HNL-Honululu");
		location.setParent(parent);
		List<Locations> locationList = new ArrayList<>();
		locationList.add(location);
		Embedded embeded = new Embedded();
		embeded.setLocations(locationList);
		Mockito.when(travelfareClient.getAirportList()).thenReturn(Fares.builder().embedded(embeded).build());
		List<Fares> fares = travelfareService.getAirportList();
		assertEquals(1, fares.size());
	}

}

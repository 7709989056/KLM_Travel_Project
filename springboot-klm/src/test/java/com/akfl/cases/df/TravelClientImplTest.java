package com.akfl.cases.df;

import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import com.afkl.cases.df.clientImpl.TravelClientImpl;
import com.afkl.cases.df.pojo.Fares;
import com.afkl.cases.df.pojo.Locations;

@RunWith(MockitoJUnitRunner.class)
public class TravelClientImplTest {

	@InjectMocks
	TravelClientImpl travelFareClinet;
	

	OAuth2RestTemplate oauthRestTemplate;

	@Before
	public void setup() throws Exception {
		this.oauthRestTemplate = mock(OAuth2RestTemplate.class);
		ReflectionTestUtils.setField(travelFareClinet, "oauthRestTemplate", oauthRestTemplate);
	}

	@Test
	public void successReceiveFareOfferTest() throws Exception {
		Fares fares = Fares.builder().origin("HNL").destination("BBA").build();
		ReflectionTestUtils.setField(travelFareClinet, "fareUrl", "fareUrl}");
		Mockito.when(oauthRestTemplate.getForObject(
		        Mockito.any(),
		        Mockito.eq(Fares.class))) 
		    .thenReturn(fares);
		Fares response = travelFareClinet.retrieveFare(fares);
		Assert.assertEquals(fares, response);
	}
	
	@Test
	public void successGetAirportNameByCodeTest() throws Exception {
		ReflectionTestUtils.setField(travelFareClinet, "airportDescUrl", "airportDescUrl}");
		Locations location = new Locations();
		location.setCode("HNL");
		location.setDescription("Honululu");
		Mockito.when(oauthRestTemplate.getForObject(
		        Mockito.any(),
		        Mockito.eq(Locations.class))) 
		    .thenReturn(location);
		Locations response = travelFareClinet.getAirportNameByCode("HNL");
		Assert.assertEquals(location, response);

	}

}

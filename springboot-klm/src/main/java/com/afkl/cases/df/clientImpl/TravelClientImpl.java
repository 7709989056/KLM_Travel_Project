package com.afkl.cases.df.clientImpl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.UriComponentsBuilder;

import com.afkl.cases.df.client.TravelfareClient;
import com.afkl.cases.df.exception.NoDataFoundException;
import com.afkl.cases.df.exception.ServerExceptionFound;
import com.afkl.cases.df.pojo.Fares;
import com.afkl.cases.df.pojo.Locations;

@Service
public class TravelClientImpl implements TravelfareClient {

	@Value("${mock.airportsurl}")
	private String airportsUrl;

	@Value("${mock.fareurl}")
	private String fareUrl;

	@Value("${mock.airportdesc.url}")
	private String airportDescUrl;
	
	@Autowired
	private OAuth2RestOperations oauthRestTemplate;

	@Override
	public Fares getAirportList() {
		try {
			return oauthRestTemplate.getForObject(airportsUrl, Fares.class);
		} catch (HttpClientErrorException e) {
			throw new NoDataFoundException();
		} catch (HttpServerErrorException e) {
			throw new ServerExceptionFound();
		}
	}

	@Override
	public Fares retrieveFare(Fares fares) {
		try {
			Map<String, String> urlParams = new HashMap<>();
			UriComponentsBuilder builder = UriComponentsBuilder
					.fromUriString(fareUrl);
			urlParams.put("origin", fares.getOrigin());
			urlParams.put("destination", fares.getDestination());
			return oauthRestTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), Fares.class);
		} catch (HttpClientErrorException e) {
			throw new NoDataFoundException();
		} catch (HttpServerErrorException e) {
			throw new ServerExceptionFound();
		}
	}

	@Override
	public Locations getAirportNameByCode(String code) {
		try {
			Map<String, String> urlParams = new HashMap<>();
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(airportDescUrl);
			urlParams.put("code", code);
			return oauthRestTemplate.getForObject(builder.buildAndExpand(urlParams).toUri(), Locations.class);
		} catch (HttpClientErrorException e) {
			throw new NoDataFoundException();
		} catch (HttpServerErrorException e) {
			throw new ServerExceptionFound();
		}
	}

}

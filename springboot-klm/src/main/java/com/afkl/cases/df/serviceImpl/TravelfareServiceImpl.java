package com.afkl.cases.df.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.afkl.cases.df.client.TravelfareClient;
import com.afkl.cases.df.pojo.Fares;
import com.afkl.cases.df.pojo.Locations;
import com.afkl.cases.df.service.TravelfareService;

@Service
public class TravelfareServiceImpl implements TravelfareService {

	@Autowired
	TravelfareClient travelfareClient;

	@Override
	public List<Fares> getAirportList() {
		Fares fares = travelfareClient.getAirportList();
		return fares.getEmbedded().getLocations().stream()
				.map(this::createFare)
				.collect(Collectors.toList());
		}

	@Override
	public Fares retrieveFare(Fares fares) {
		Fares response = travelfareClient.retrieveFare(fares);
		return getDescription(response);
	}

	/**
	 * fetch airport details based on airport code
	 * @param fares
	 * @return response
	 */
	private Fares getDescription(Fares fares) {
		Fares response = Fares.builder().build();
		response.setOrigin(getAirportNameByCode(fares.getOrigin()).getDescription());
		response.setDestination(getAirportNameByCode(fares.getDestination()).getDescription());
		response.setCurrency(fares.getCurrency());
		response.setAmount(fares.getAmount());
		return response;
	}

	private Locations getAirportNameByCode(String code) {
		return travelfareClient.getAirportNameByCode(code);
	}
	
	private Fares createFare(Locations location) {
		return Fares.builder()
				.origin(location.getCode())
				.originDesc(location.getDescription())
				.destination(location.getParent().getParent().getCode())
				.destinationDesc(location.getParent().getParent().getDescription())
				.build();
	}

}

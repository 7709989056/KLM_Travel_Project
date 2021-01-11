package com.afkl.cases.df.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.afkl.cases.df.pojo.Fares;
import com.afkl.cases.df.service.TravelfareService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class TravelfareController {

	 @Autowired
	 TravelfareService travelfareService;
	 
	/**
	 * method to get airport origin,destination and their description
	 * @return
	 */
	@GetMapping("/airports")
	public List<Fares> getAirportList() {
		return travelfareService.getAirportList();
	}
	
	/**
	 * Retrieve fare offer
	 * @param fares
	 * @return
	 */
	@PostMapping("/fares")
	public Fares retriveFareOffer(@RequestBody Fares fares) {
		return travelfareService.retrieveFare(fares);

	}
	
	

}

package com.afkl.cases.df.service;

import java.util.List;
import com.afkl.cases.df.pojo.Fares;

 public interface TravelfareService {

	public List<Fares> getAirportList();

	public Fares retrieveFare(Fares fares);

}

package com.afkl.cases.df.client;

import com.afkl.cases.df.pojo.Fares;
import com.afkl.cases.df.pojo.Locations;

   public interface TravelfareClient {

		public Fares getAirportList();
	
		public Fares retrieveFare(Fares fares);
	
		public Locations getAirportNameByCode(String code);
	

}

package com.afkl.cases.df.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fares {
	
	@JsonProperty("_embedded")
	private Embedded embedded;
	private Locations location;
	private Page page;
	public String origin;
	public String destination;
	public String originDesc;
	public String destinationDesc;
	public String currency;
	public String amount;
}

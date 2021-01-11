package com.afkl.cases.df.pojo;

import lombok.Data;

@Data
public class Locations {
	public Parent parent;
	public String code;
	public String description;
	public String name;
	public Coordinates coordinates;
	public Fares fares;

}

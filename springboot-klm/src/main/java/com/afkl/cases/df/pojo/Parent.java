package com.afkl.cases.df.pojo;

import lombok.Data;

@Data
public class Parent {
	private String code;
	private String name;
	private String description;
	public Coordinates coordinates;
	public Parent parent;
}

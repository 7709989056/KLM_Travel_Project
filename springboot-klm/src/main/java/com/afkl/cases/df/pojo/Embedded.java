package com.afkl.cases.df.pojo;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class Embedded {
	private List <Locations> locations = new ArrayList <Locations> ();
}

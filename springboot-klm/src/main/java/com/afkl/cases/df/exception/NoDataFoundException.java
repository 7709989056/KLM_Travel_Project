package com.afkl.cases.df.exception;

public class NoDataFoundException extends RuntimeException{
	
	 public NoDataFoundException() {
	        super(String.format("No data Found"));
	   }
}

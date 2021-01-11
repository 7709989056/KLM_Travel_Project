package com.afkl.cases.df.exception;

public class ServerExceptionFound extends RuntimeException {
	 public ServerExceptionFound() {
	        super(String.format("Internal server error"));
	   }
}


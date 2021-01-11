package com.afkl.cases.df.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	
	  @ExceptionHandler(NoDataFoundException.class)
	    public ResponseEntity<Object> recordNotFoundException(
	    		NoDataFoundException ex, WebRequest request) {
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "No Record found");
	        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	    }
	  @ExceptionHandler(ServerExceptionFound.class)
	    public ResponseEntity<Object> internalServerException(
	    		ServerExceptionFound ex, WebRequest request) {
	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", "Internal Server Error");
	        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  
	  
}

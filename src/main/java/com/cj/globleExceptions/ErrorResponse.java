package com.cj.globleExceptions;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.http.HttpStatus;

@XmlRootElement(name = "error")
public class ErrorResponse {

	public ErrorResponse(String message,HttpStatus statuscode, List<String> details) {
        super();
        
        this.message = message;
        this.details = details;
        this.statuscode = statuscode;
        
    }
 
	private  HttpStatus statuscode;
    //General error message about nature of error
    private String message;
 
    //Specific errors in API request processing
    private List<String> details;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	public HttpStatus getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(HttpStatus statuscode) {
		this.statuscode = statuscode;
	}

	
    
    
    
    
    
}

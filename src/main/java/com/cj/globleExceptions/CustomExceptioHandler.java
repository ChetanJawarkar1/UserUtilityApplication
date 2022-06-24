package com.cj.globleExceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.jsonwebtoken.ExpiredJwtException;

@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class CustomExceptioHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handUserNotFoundException(UserNotFoundException ex, WebRequest request){
				
		 List<String> details = new ArrayList<>();
	          //details.add(ex);
	        ErrorResponse error = new ErrorResponse("Such Username not exist", details);
	        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("RECORD NOT AVIALABLE", details);
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }
	
	 @ExceptionHandler(value = ExpiredJwtException.class)
	   public ResponseEntity<Object> exception(ExpiredJwtException exception) {
		 System.out.println(":::::CustomExceptioHandler::::::");
	      return new ResponseEntity<>("TOKEN IS EXPIRED", HttpStatus.ALREADY_REPORTED);
	   }
	
	/*
	 * @ExceptionHandler(Token_Exception.class) public final ResponseEntity<Object>
	 * handleTokenException(Token_Exception ex, WebRequest request) { List<String>
	 * details = new ArrayList<>(); details.add(ex.getLocalizedMessage());
	 * System.out.println("ALA ITH"); ErrorResponse error = new
	 * ErrorResponse("TOKEN ISSUE", details); return new ResponseEntity(error,
	 * HttpStatus.UNAUTHORIZED); }
	 */

}

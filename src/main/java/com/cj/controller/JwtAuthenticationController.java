package com.cj.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cj.globleExceptions.ErrorResponse;
import com.cj.security.JwtRequest;
import com.cj.security.JwtResponse;
import com.cj.security.JwtTokenUtil;
import com.cj.security.JwtUserDetailsService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
public class JwtAuthenticationController {

	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		System.out.println("JWT REQUEST PARAMETER::email::"+authenticationRequest.getUsername()+" Password::"+authenticationRequest.getPassword());
		
		 String token = null ;
		 List<String> lst = Arrays.asList("Invalid token");
		try {
			
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		 token = jwtTokenUtil.generateToken(userDetails);
		
		System.out.println("Userdetailservice toekn::"+token);
		}catch (Exception e) {
			System.out.println("controller exception"+e);
			return ResponseEntity.ok(new ErrorResponse(e.getMessage(),HttpStatus.NOT_FOUND,lst));
		}

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		System.out.println("JwtAuthenticationController authenticate");
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}

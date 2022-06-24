package com.cj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cj.dto.User;
import com.cj.security.JwtRequest;


public interface UserService {

	public List<User> fetchUserData();
	
	public User insertUserData(User u);
	
	public User fetchUserById(long id);
	
	public void deleteUser(long id);
	
	public User updataData(User i);
	
	
}

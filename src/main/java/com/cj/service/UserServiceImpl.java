package com.cj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cj.dao.UserDaoInterface;
import com.cj.dto.User;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDaoInterface dao;
	
	
	@Override
	public List<User> fetchUserData() {
		// TODO Auto-generated method stub

		//return us;
		return dao.findAll();
	}

	@Override
	public User insertUserData(User u) {
		// TODO Auto-generated method stub
		
		//return "Hekko";
		return dao.save(u);
	}

	@Override
	public User fetchUserById(long id) {
		// TODO Auto-generated method stub
		
		Optional<User> user =dao.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		return user.get();
	}

	@Override
	public void deleteUser(long id) {
		
	 dao.deleteById(id);
	}

	@Override
	public User updataData(User i) {
		
		return dao.save(i);
	}

}

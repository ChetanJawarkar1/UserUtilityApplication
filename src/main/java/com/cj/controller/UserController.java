package com.cj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cj.dto.User;
import com.cj.security.JwtRequest;
import com.cj.service.UserService;


@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	

        @PostMapping("/upload")
        public String upload(@RequestParam("file") MultipartFile file, 
                             @RequestParam("user") User user) {
            return user + "\n" + file.getOriginalFilename() + "\n" + file.getSize();
        }

	
	
	
	@GetMapping({ "/hello" })
	public String hello() {
		return "Hello World";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestBody JwtRequest user) {
		
		System.out.println("EMAIL="+user.getUsername()+" Password:"+user.getPassword());
		
		if(user.getUsername().equals("ABC") && user.getPassword().equals("123"))
		return "SUCCESS";
		
		return "LOGIN FAILED";
	}
	
	
	@GetMapping("/users")
    public List<User> getUser() {
       	System.out.println("Feching all User data");
        return service.fetchUserData();
    }
	
	@PostMapping("/postusers")
	public void inserData(@RequestBody User user) {
		System.out.println("===>"+user.toString());
		user = service.insertUserData(user);
		
	}
	
	@GetMapping("/getUserById/{id}")
	public User inserData(@PathVariable ("id") Long id) {
		System.out.println("User Id are===>"+id);
		return service.fetchUserById(id);
	}
	
	@PutMapping("/updateUser")
	public User updateData(@RequestBody User u) {
	System.out.println("Updating User Id are===>"+u.getId());
	 return service.updataData(u);
	}
	
	@DeleteMapping("/DeleteUser/{id}")
	public String DeleteUser(@PathVariable ("id") Long id) {
		System.out.println("Deletion Operation User Id are===>"+id);
		 service.deleteUser(id);
		 
		 return "success";
	}

}

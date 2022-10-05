package com.cj.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.IntStream;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cj.dto.User;
import com.cj.security.JwtRequest;
import com.cj.service.UserService;


@CrossOrigin(origins="http://localhost:3000")
@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@Value("${upoadDir}")
	private String uploadFolder;
	

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
		System.out.println("welcome to login controller");
		System.out.println("EMAIL="+user.getUsername()+" Password:"+user.getPassword());
		
		if(user.getUsername().equals("cj") && user.getPassword().equals("password"))
		return "SUCCESS";
		
		return "LOGIN FAILED";
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/users")
    public List<User> getUser() {
       	System.out.println("Feching all User data");
       	
       	List<User> lst = service.fetchUserData();
       	for(int i =0;i<lst.size();i++) {
       		System.out.println("Before =>"+lst.get(i).getImage());
       		//lst.get(i).setImage(Base64Utils.encode(lst.get(i).getImage()));
       		byte [] d = Base64Utils.encode(lst.get(i).getImage());
       		System.out.println("AFTER =>"+d);
       		
       	}
         return lst ;
    }
	

	
	@PostMapping("/insertData")
	public void inserData(@RequestBody User user) {
		System.out.println("===>"+user.toString());
		user = service.insertUserData(user);
		
	}
	

	
	@PostMapping(value = "/insertUserWithToken")
	public void inserData1(@ModelAttribute @Valid User user, MultipartFile imagefile) throws IOException, SerialException, SQLException {
		System.out.println("sucess"+user.toString());
	   byte[] byteObjects = convertToBytes(imagefile);
		user.setImage(byteObjects);
		user = service.insertUserData(user);
		System.out.println("sucess"+user.toString()+" Multipart"+imagefile.getBytes());
		
	}
	
	private byte[] convertToBytes(MultipartFile file) throws IOException {
        byte[] byteObjects = new byte[file.getBytes().length];
        int i = 0;
        for (byte b : file.getBytes()) {
            byteObjects[i++] = b;
        }return byteObjects;}
	
	@GetMapping("/getUserById/{id}")
	public User inserData(@PathVariable ("id") Long id) {
		System.out.println("User Id are===>"+id);
		return service.fetchUserById(id);
	}
	
	
	@PutMapping(value = "/updateUserWithToken")
	public User updateUser1(@ModelAttribute @Valid User user, MultipartFile imagefile) throws IOException, SerialException, SQLException {
	System.out.println("Updating User Id are===>"+user.getId());
	
	 byte[] byteObjects = convertToBytes(imagefile);
	 user.setImage(byteObjects);
	 return service.updataData(user);
	}
	
	
	
	@PutMapping("/updateUser")
	public User updateData1(@RequestBody User u) {
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

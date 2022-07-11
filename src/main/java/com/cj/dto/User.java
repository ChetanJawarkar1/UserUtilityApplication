package com.cj.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

@Entity
@Table(name = "test_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private  String firstName = "";
    private  String lastName = "";;
    private  String email = "";
    @Lob
    private byte image[] ;
    
    
    
    public User() {
    	
    }
    
    
    
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public User(String firstName, String lastName, String email,byte[] image) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.image = image;
	}
	


	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}





	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return " firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	
    
    
}

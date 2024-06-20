package com.myapp.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class User {
    @Id
	private String id;
	private String email;
	private String firstName;
	private String lastName;
	private String phoneNumber ;
	private String dateOfBirth ;
	private String accessToken ;
	private Long created ;
	private Long modified ;
	private byte[] profileImage;
	
//    @DBRef
//    private Account account ;
//	
   

//	public User(String email, String firstName, String lastName, String phoneNumber, String dateOfBirth,
//			String accessToken, Long created, Long modified, byte[] profileImage, Account account) {
//		super();
//		this.email = email;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.phoneNumber = phoneNumber;
//		this.dateOfBirth = dateOfBirth;
//		this.accessToken = accessToken;
//		this.created = created;
//		this.modified = modified;
//		this.profileImage = profileImage;
//	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public byte[] getProfileImage() {
		return profileImage;
	}
	
	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getCreated() {
		return created;
	}
	
	public void setCreated(Long created) {
		this.created = created;
	}
	
	public Long getModified() {
		return modified;
	}
	
	public void setModified(Long modified) {
		this.modified = modified;
	}
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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

//	 public Account getAccount() {
//	        return account;
//	    }
//
//	    public void setAccount(Account account) {
//	        this.account = account;
//	    }
	
}

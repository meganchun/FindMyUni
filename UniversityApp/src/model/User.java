package model;

import java.util.List;


public class User {

	//Instance variables
	private byte[] userName;
	private byte[] password;
	private String name;
	private String numAddress;
	private String emailAddress;
	private String fieldOfStudy;
	private List<Program> savedPrograms;
	private List<String[]> marks;
	
	//sd
	
	//Constructor
	public User(byte[] encryptedUsernameByte, byte[] encryptedPasswordByte) {
		super();
		this.userName = encryptedUsernameByte;
		this.password = encryptedPasswordByte;

	}

	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumAddress() {
		return numAddress;
	}

	public void setNumAddress(String numAddress) {
		this.numAddress = numAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public byte[] getUserName() {
		return userName;
	}

	public void setUserName(byte[] userName) {
		this.userName = userName;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public String getFieldOfStudy() {
		return fieldOfStudy;
	}

	public void setFieldOfStudy(String fieldOfStudy) {
		this.fieldOfStudy = fieldOfStudy;
	}

	public List<Program> getSavedPrograms() {
		return savedPrograms;
	}

	public void setSavedPrograms(List<Program> savedPrograms) {
		this.savedPrograms = savedPrograms;
	}

	public List<String[]> getMarks() {
		return marks;
	}

	public void setMarks(List<String[]> marks) {
		this.marks = marks;
	}
	
	
	
	
	
}

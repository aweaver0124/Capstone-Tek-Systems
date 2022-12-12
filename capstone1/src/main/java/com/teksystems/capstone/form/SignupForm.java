package com.teksystems.capstone.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.teksystems.capstone.validation.UsernameUnique;

import lombok.ToString;

@ToString
public class SignupForm {
	
	@NotEmpty(message= "First name is required.")
	@Length(max = 50, message = "First name must be less than 50 characters.")
	private String firstName;
	
	@NotEmpty(message = "Last name is required.")
	@Length(max = 50, message = "Last name must be less than 50 characters.")
	private String lastName;
	
	@NotEmpty(message= "State is required.")
	private String state;
	
	@NotEmpty(message= "Username is required.")
	@Length(max = 50, message = "Username must be less than 45 characters.")
	// @Pattern(regexp = "[a-zA-Z0-9]", message = "Username can only contain alphanumeric characters.")
	@UsernameUnique(message= "This username is taken. Please choose another.")
	private String username;
	
	@NotEmpty(message= "Password is required.")
	@Length(min = 8, max = 50, message = "Password must be inbetween 8 and 50 characters long.")
	// @Pattern(regexp = "[a-zA-Z0-9!@#$%&*]", message = "Password must include at least one lowercase letter, at least one uppercase letters, and at least one special character.")
	private String password;
	
	@NotEmpty(message= "Please confirm your password.")
	private String confirmPassword;
	
	// Getters and Setters
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
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}

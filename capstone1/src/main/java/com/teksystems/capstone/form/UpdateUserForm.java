package com.teksystems.capstone.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class UpdateUserForm {
	
	@NotEmpty(message= "First name is required.")
	@Length(max = 50, message = "First name must be less than 50 characters.")
	private String firstName;
	
	@NotEmpty(message= "Last name is required.")
	@Length(max = 50, message = "Last name must be less than 50 characters.")
	private String lastName;
	
	@NotEmpty(message= "State is required.")
	private String state;

}

package com.teksystems.capstone.form;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddPetForm {

	@NotEmpty(message= "Name is required.")
	@Length(max = 45, message = "Name must be less than 45 characters.")
	private String name;
	
	@NotEmpty(message = "Species is required.")
	private String species;
	
	@Length(max = 250, message = "Image source must be less than 250 characters.")
	private String image;
	
	@NotEmpty(message = "Breed is required.")
	private String breed;
	
	// @NotEmpty(message = "Birthday cannot be empty.")
	private Date birthDate;
	
	@NotEmpty(message = "Gender cannot be empty.")
	private String gender;
	
	@NotEmpty(message = "Personality cannot be empty.")
	@Length(max = 250, message = "Personality must be less than 250 characters.")
	private String personality;
	
	private Integer userId;
}

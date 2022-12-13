package com.teksystems.capstone.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import lombok.*;
 @Getter
 @Setter
@ToString
public class AddVaccinationForm {
	 
	 private Integer vaccinationId;
	 private Integer petId;
	 

	 private Date dateReceived;
	 
	
	 private Date expirationDate;
	 
	 @NotEmpty(message = "Clinic name cannot be empty.")
	 @Length(max = 70, message = "Clinic Name cannot exceed 70 characters.")
	 private String clinicName;

}

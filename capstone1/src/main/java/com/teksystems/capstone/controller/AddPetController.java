package com.teksystems.capstone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.capstone.database.dao.PetDAO;
import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.entity.Pet;
import com.teksystems.capstone.database.entity.User;
import com.teksystems.capstone.database.entity.UserRole;
import com.teksystems.capstone.form.AddPetForm;
import com.teksystems.capstone.form.SignupForm;
import com.teksystems.capstone.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AddPetController {
	
	@Autowired
	private AuthenticatedUserService authUser;
	
	@Autowired
	private PetDAO petDao;
	
	@RequestMapping(value = "/addAPet", method = RequestMethod.GET)
	public ModelAndView addPet() {
		ModelAndView response = new ModelAndView();
		response.setViewName("addAPet");
		
		log.debug("This is in the GET method for /addAPet");
		
		return response;
	}
	
	// Submit add pet form
	@RequestMapping(value = "/addAPet", method = RequestMethod.POST)
	public ModelAndView signUpSubmit(@Valid AddPetForm form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("/addAPet");
		
		log.debug("This is in the POST method for /addAPet");
		log.debug(form.toString());
		
		User user = authUser.getCurrentUser();
		response.addObject("user", user);
		
		for ( ObjectError e:  bindingResult.getAllErrors()) {
			log.debug(e.getDefaultMessage());
		}
		
		if ( ! bindingResult.hasErrors()) {
			Pet pet = new Pet();
			
			pet.setName(form.getName());
			pet.setSpecies(form.getSpecies());
			pet.setImage(form.getImage());
			pet.setBreed(form.getBreed());
			pet.setBirthDate(form.getBirthDate());
			pet.setGender(form.getGender());
			pet.setPersonality(form.getPersonality());
			pet.setUser(user);
			
			petDao.save(pet);
			
		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}
		
		return response;
	}

}

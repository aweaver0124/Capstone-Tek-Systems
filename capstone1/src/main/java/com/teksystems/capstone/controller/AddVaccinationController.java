package com.teksystems.capstone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.capstone.database.dao.PetDAO;
import com.teksystems.capstone.database.dao.Pet_VaccinationDAO;
import com.teksystems.capstone.database.dao.VaccinationDAO;
import com.teksystems.capstone.database.entity.Pet;
import com.teksystems.capstone.database.entity.Pet_Vaccination;
import com.teksystems.capstone.database.entity.Vaccination;
import com.teksystems.capstone.form.AddVaccinationForm;
import com.teksystems.capstone.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AddVaccinationController {

	@Autowired
	private AuthenticatedUserService authUser;

	@Autowired
	private VaccinationDAO vaxDao;
	
	@Autowired
	private PetDAO petDao;
	
	@Autowired
	private Pet_VaccinationDAO pvDao;
	
	Pet currentPet;
	Vaccination currentVax;
	

	@RequestMapping(value = "/addVaccination", method = RequestMethod.GET)
	public ModelAndView getVaccines(@RequestParam(value="id", required = false) Integer id) {
		ModelAndView response = new ModelAndView();
		response.setViewName("addVaccination");
		
		List<Vaccination> vaccines = vaxDao.finbByVaccinesIdGreaterThanZero();
		currentPet = petDao.findById(id);
		
		response.addObject("petId", id);
		response.addObject("currentPet", currentPet);
		response.addObject("vaccines", vaccines);

		return response;
	}


	// GET vax ID and pet ID
	@RequestMapping(value = "/addVaccination/submit", method = RequestMethod.GET)
	public ModelAndView getVaxAndPest(@RequestParam(value="vaxName", required = false) String vaxName, @RequestParam(value="petId", required = false) Integer id) {
		ModelAndView response = new ModelAndView();
		response.setViewName("addVaccination");

		response.addObject("vaxName", vaxName);
		response.addObject("petId", id);
		
		currentVax = vaxDao.findByNameLike(vaxName);
		currentPet = petDao.findById(id);
		
		log.debug(currentPet.toString());
		log.debug(currentVax.toString());
	
		return response;
	}
	
	@RequestMapping(value = "/addVaccination/submit", method = RequestMethod.POST)
		public ModelAndView submitForm(@Valid AddVaccinationForm form,  BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("addVaccination");
		
		
		for ( ObjectError e:  bindingResult.getAllErrors()) {
			log.debug(e.getDefaultMessage());
		}
		
		if ( ! bindingResult.hasErrors()) {
			
			Pet_Vaccination pv = new Pet_Vaccination();
			
			pv.setPetId(currentPet.getId());
			pv.setVaccinationId(currentVax.getId());
			pv.setClinicName(form.getClinicName());
			pv.setDateReceived(form.getDateReceived());
			pv.setExpirationDate(form.getExpirationDate());
			
			pvDao.save(pv);
			
		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}
		
		return response;
	}
}

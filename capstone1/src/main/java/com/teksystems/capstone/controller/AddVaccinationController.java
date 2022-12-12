package com.teksystems.capstone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.capstone.database.dao.PetDAO;
import com.teksystems.capstone.database.dao.VaccinationDAO;
import com.teksystems.capstone.database.entity.Vaccination;
import com.teksystems.capstone.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AddVaccinationController {

	@Autowired
	private AuthenticatedUserService authUser;

	@Autowired
	private VaccinationDAO vaxDao;

	@RequestMapping(value = "/addVaccination", method = RequestMethod.GET)
	public ModelAndView getVaccines() {
		ModelAndView response = new ModelAndView();
		response.setViewName("addVaccination");
		
		List<Vaccination> vaccines = vaxDao.finbByVaccinesIdGreaterThanZero();

		response.addObject("vaccines", vaccines);

		return response;
	}


	@RequestMapping(value = "/addVaccination/submit", method = RequestMethod.GET)
	public ModelAndView seeVaccineList(@RequestParam(required = false) String vaxName) {
		ModelAndView response = new ModelAndView();
		response.setViewName("addVaccination");

		response.addObject("vaxName", vaxName);
	
		log.debug(vaxName);
		return response;
	}

}

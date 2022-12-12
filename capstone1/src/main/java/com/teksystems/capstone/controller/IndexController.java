package com.teksystems.capstone.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.capstone.database.dao.PetDAO;
import com.teksystems.capstone.database.dao.Pet_VaccinationDAO;
import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.dao.VaccinationDAO;
import com.teksystems.capstone.database.entity.Pet;
import com.teksystems.capstone.database.entity.Pet_Vaccination;
import com.teksystems.capstone.database.entity.User;
import com.teksystems.capstone.database.entity.Vaccination;
import com.teksystems.capstone.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class IndexController {
	
	@Autowired
	private AuthenticatedUserService authUser;
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private PetDAO petDao;
	
	@Autowired
	private VaccinationDAO vaxDao;
	
	@Autowired
	private Pet_VaccinationDAO pvDao;
	
	// Landing Page for unauthenticated users
	@RequestMapping(value = {"/", "/index", "/index.html"}, method = RequestMethod.GET)
	public ModelAndView slash() {
		ModelAndView response = new ModelAndView();
		response.setViewName("landing");
		
		System.out.println("Index controller request");
		
		return response;
	}
	
	// Home Page for authenticated users
	@RequestMapping(value = {"/home"}, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView response = new ModelAndView();
		response.setViewName("home");
		
		User user = authUser.getCurrentUser();
		// log.debug(user.toString());
		
		List<Pet> pets = petDao.findByUserId(user.getId());
		// log.debug(pets.toString());
		
		response.addObject("pets", pets);
		response.addObject("user", user);
		
		return response;
	}
	
	 // Get individual pet card
	@RequestMapping(value = {"/petcard"})
	public ModelAndView petCard(@RequestParam(value="id", required=false) Integer id) {
		ModelAndView response = new ModelAndView();
		response.setViewName("petcard");
		
		Pet currentPet = petDao.findById(id);
		log.debug(currentPet.toString());
		
		List<Map<String,Object>> vaccines = vaxDao.getPetVaccinations(currentPet.getId());
		log.debug(vaccines.toString());

		response.addObject("vaccines", vaccines);
		response.addObject("currentPet", currentPet);
		
		return response;
	}
}

// Later Date

//on Add a pet form -- This is file upload class example
// change this as needed in your final project 
//@RequestMapping(value= {"/fileupload"}, method = RequestMethod.GET)
//public ModelAndView fileUpload() {
//	ModelAndView response = new ModelAndView();
//	response.setViewName("fileupload");
//	
//	return response;
//}

// This is how/where the file upload will submit to
//@RequestMapping(value = { "/fileuploadSubmit" }, method = RequestMethod.POST)
//public ModelAndView fileuploadSubmit(@RequestParam MultipartFile file) throws IOException {
//	ModelAndView response = new ModelAndView();
//	response.setViewName("fileupload");
//	
//	log.debug("Filename  = " + file.getOriginalFilename());
//	log.debug("File Size = " + file.getSize() + " bytes" );
//	
//	File targetFile = new File("./src/main/webapp/pub/images/" + file.getOriginalFilename());
//	
//    FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);
//   
//    response.addObject("filename", "/pub/images/" + file.getOriginalFilename());
//	return response;
//}

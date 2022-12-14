package com.teksystems.capstone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.entity.User;
import com.teksystems.capstone.form.UpdateUserForm;
import com.teksystems.capstone.security.AuthenticatedUserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UpdateUserController {
	
	@Autowired
	private AuthenticatedUserService authUser;
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value="/editUser", method = RequestMethod.GET)
	public ModelAndView editUser() {
		ModelAndView response = new ModelAndView();
		response.setViewName("editUser");
		
		log.debug("GET /editUser");
		return response;
	}

	
	
	@RequestMapping(value = "/editUser", method = RequestMethod.POST)
	public ModelAndView submitEdit(@Valid UpdateUserForm form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("editUser");
		
		for(ObjectError e: bindingResult.getAllErrors()) {
			log.debug(e.getDefaultMessage());
		}
		
		if (!bindingResult.hasErrors()) {
			User user = authUser.getCurrentUser();
			
			user.setFirstName(form.getFirstName());
			user.setLastName(form.getLastName());
			user.setState(form.getState());
			
			userDao.save(user);
		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}
		
		return response;
	}

}

















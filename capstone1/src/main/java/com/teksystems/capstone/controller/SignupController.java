package com.teksystems.capstone.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.dao.UserRoleDAO;
import com.teksystems.capstone.database.entity.User;
import com.teksystems.capstone.database.entity.UserRole;
import com.teksystems.capstone.form.SignupForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SignupController {

	@Autowired
	private UserDAO userDao;

	@Autowired
	UserRoleDAO userRoleDao;

	@Autowired
	@Qualifier("passwordEncoder")
	private PasswordEncoder passwordEncoder;

	// For signup
	// To signup page
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView signUp() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_signup_pages/signup");
		log.debug("This is in the GET method for /signup");
		return response;
	}

	// Submit signup form
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signUpSubmit(@Valid SignupForm form, BindingResult bindingResult) {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_signup_pages/signup");

		log.debug("This is in the POST method for /signup");
		log.debug(form.toString());

		for (ObjectError e : bindingResult.getAllErrors()) {
			log.debug(e.getDefaultMessage());
		}
		
//		String confirmPassword = form.getConfirmPassword();
//		response.addObject("confirmPassword", confirmPassword);
		
		if (!bindingResult.hasErrors()) {
			User user = new User();

			String encodedPassword = passwordEncoder.encode(form.getPassword());
			user.setPassword(encodedPassword);

			user.setFirstName(form.getFirstName());
			user.setLastName(form.getLastName());
			user.setState(form.getState());
			user.setUsername(form.getUsername());

			userDao.save(user);

			UserRole ur = new UserRole();
			ur.setRole("USER");
			ur.setUserId(user.getId());

			userRoleDao.save(ur);
			response.setViewName("login_signup_pages/login");
			
		} else {
			response.addObject("bindingResult", bindingResult);
			response.addObject("form", form);
		}
		
		return response;
	}

	// Login
	// To login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login_signup_pages/login");

		return response;
	}
}

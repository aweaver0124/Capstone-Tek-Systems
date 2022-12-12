package com.teksystems.capstone.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
	
	@RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView response = new ModelAndView();
		response.setViewName("admin/admin");
		
		System.out.println("Admin controller request");
		
		return response;
	}
}

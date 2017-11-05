package com.bus.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bus.service.beans.User;


@Controller
@RequestMapping("/")
public class RegistrationController {
	@Autowired
	@Qualifier("userValidator")
	private Validator userValidator;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(userValidator);
	}

	/*@ModelAttribute
	public User getUser() {
		return new User();
	}*/
	
	@GetMapping("/registerUser")
	public String register(Model model){
		model.addAttribute("user",new User());
		return "Register";
	}

	
	@PostMapping("/registerUser")
	public String registerUser(@Validated @ModelAttribute("user") User user, BindingResult errors) {
		if (errors.hasErrors()) {
			System.out.println("Errors occured....!");
			return "Register";
		}
		return "Success";

	}

}

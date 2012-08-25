package com.example.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping(value="/show", method = RequestMethod.GET)
	public void show(Model model) {
		model.addAttribute("message", "Hello world to Spring!");
	}
}

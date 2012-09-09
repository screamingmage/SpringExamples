package com.thales.ntisjtms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.thales.ntisjtms.service.PublishingService;

@Controller
@RequestMapping("/ntis")
public class NtisController {
	
	private static final Logger LOG = LoggerFactory.getLogger(NtisController.class);
	
	@Autowired
	private PublishingService publishingService;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public void home() {
		LOG.info("page loaded");
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST, params="equipment")
	public ModelAndView equipment(@RequestParam("url") String url) { 
		LOG.info("publishing equipment to " + url);
		return new ModelAndView("redirect:home");
	}
	
	@RequestMapping(value="/send", method=RequestMethod.POST, params="configuration")
	public ModelAndView configuration(@RequestParam("url") String url) { 
		LOG.info("publishing configuration to " + url);
		publishingService.sendConfigurationData(url);
		return new ModelAndView("redirect:home");
	}
}

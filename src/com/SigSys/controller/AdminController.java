package com.SigSys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SigSys.cache.VisitorsCache;
import com.SigSys.cache.VisitsCache;

@Controller
public class AdminController {

	@Autowired
	VisitsCache visitsCache;
	
	@Autowired
	VisitorsCache visitorsCache;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(ModelMap modelMap) {
		return "admin";
	}
	
}

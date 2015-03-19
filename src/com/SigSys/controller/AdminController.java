package com.SigSys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SigSys.cache.VisitorsCache;
import com.SigSys.cache.VisitsCache;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired
	VisitsCache visitsCache;
	
	@Autowired
	VisitorsCache visitorsCache;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String admin(ModelMap modelMap) {
		return "admin";
	}
	
	@RequestMapping(value = "/reloadVisit", method = RequestMethod.GET)
	public String reloadVisit(ModelMap modelMap) {
		visitsCache.refresh();
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/reloadVisitor", method = RequestMethod.GET)
	public String reloadVisitor(ModelMap modelMap) {
		visitorsCache.refresh();
		return redirect("homepage");
	}
	
	private String redirect(String page) {
		return "redirect:" + page;
	}
	
}

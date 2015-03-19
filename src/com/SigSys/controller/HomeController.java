package com.SigSys.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SigSys.cache.VisitsCache;
import com.SigSys.form.NewVisitForm;
import com.SigSys.model.Company;
import com.SigSys.model.Visit;

@Controller
public class HomeController {
	
	@Autowired
	VisitsCache visitsCache;
	
	@ModelAttribute("visits")
	public List<Visit> getVisits() {
		List<Visit> visits = new ArrayList<Visit>();
		visits.addAll(visitsCache.getVisits().values());
		return visits;
	}
	
	private List<Company> getCompanies() {
		return Arrays.asList(Company.values());
	}
	
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String homepage(ModelMap modelMap) {
		if (!visitsCache.isEmpty()) {
			modelMap.addAttribute("isEmpty", "false");
		} else {
			modelMap.addAttribute("isEmpty", "true");
		}
		modelMap.addAttribute("newVisitForm", new NewVisitForm());
		modelMap.addAttribute("companies", getCompanies());
		return "homepage";
	}	
}

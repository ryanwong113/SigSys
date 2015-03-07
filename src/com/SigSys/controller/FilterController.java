package com.SigSys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SigSys.cache.VisitorsCache;
import com.SigSys.cache.VisitsCache;
import com.SigSys.form.FilterVisitorsForm;
import com.SigSys.form.FilterVisitsForm;
import com.SigSys.model.Company;

@RequestMapping("/filter")
@Controller
public class FilterController {

	@Autowired
	VisitsCache visitsCache;
	
	@Autowired
	VisitorsCache visitorsCache;
	
	@ModelAttribute("companies")
	public List<String> getCompanies() {
		List<String> companies = new ArrayList<String>();
		for (Company company : Company.values()) {
			companies.add(company.name());
		}
		return companies;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String filter(ModelMap modelMap) {
		modelMap.addAttribute("filterVisitsForm", new FilterVisitsForm());
		modelMap.addAttribute("filterVisitorsForm", new FilterVisitorsForm());
		return "filterPage";
	}
	
	@RequestMapping(value = "/visits", method = RequestMethod.POST)
	public String filterVisits(ModelMap modelMap, @ModelAttribute("filterVisitsForm") FilterVisitsForm filterVisitsForm) {
		
		return "viewVisits";
	}
	
	@RequestMapping(value = "/visitors", method = RequestMethod.POST)
	public String filterVisitors(ModelMap modelMap, @ModelAttribute("filterVisitorsForm") FilterVisitorsForm filterVisitorsForm) {
		
		return "viewVisitors";
	}
	
}

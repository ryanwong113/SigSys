package com.SigSys.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SigSys.form.FilterVisitorsForm;
import com.SigSys.form.FilterVisitsForm;
import com.SigSys.model.Company;

@RequestMapping("/filter")
@Controller
public class FilterController {
	
	private List<Company> getCompanies() {
		return Arrays.asList(Company.values());
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String filter(ModelMap modelMap) {
		modelMap.addAttribute("filterVisitsForm", new FilterVisitsForm());
		modelMap.addAttribute("filterVisitorsForm", new FilterVisitorsForm());
		modelMap.addAttribute("companies", getCompanies());
		return "filterPage";
	}	
}

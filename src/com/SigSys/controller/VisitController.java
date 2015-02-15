package com.SigSys.controller;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SigSys.cache.VisitorsCache;
import com.SigSys.cache.VisitsCache;
import com.SigSys.form.NewVisitForm;
import com.SigSys.form.TestVisitForm;
import com.SigSys.model.Company;
import com.SigSys.model.Visit;
import com.SigSys.model.Visitor;

@Controller
public class VisitController {
	
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
	
	@ModelAttribute("visits")
	public List<Visit> getVisits() {
		List<Visit> visits = new ArrayList<Visit>();
		visits.addAll(visitsCache.getVisits().values());
		return visits;
	}
	
	@ModelAttribute("testVisitForm")
	public TestVisitForm getTestVisitForm() {
		return new TestVisitForm();
	}
	
	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public String showVisits(ModelMap modelMap) {
		if (!visitsCache.isEmpty()) {
			modelMap.addAttribute("isEmpty", "false");
		} else {
			modelMap.addAttribute("isEmpty", "true");
		}
		return "homepage";
	}
	
	@RequestMapping(value = "/addVisit", method = RequestMethod.GET)
	public String addVisit(ModelMap modelMap) {
		modelMap.addAttribute("newVisitForm", new NewVisitForm());
		return "newVisit";
	}
	
	@RequestMapping(value = "/addVisit", method = RequestMethod.POST)
	public String addVisit(ModelMap modelMap, @ModelAttribute("newVisitForm") NewVisitForm newVisitForm) {
		Visit newVisit = newVisitForm.getVisit();
		Visitor newVisitor = newVisitForm.getVisitor();
		
		DateTime currentDateTime = new DateTime();
		newVisit.setTimeIn(currentDateTime);
		newVisit.setVisitor(newVisitor);
		
		visitsCache.addVisit(newVisit);
		
		if (!visitorsCache.contains(newVisitor)) {
			visitorsCache.addVisitor(newVisitor);
		}
		
		return "homepage";
	}
	
	@RequestMapping(value = "/updateVisit", method = RequestMethod.GET)
	public String updateVisit(ModelMap modelMap, Visit visit) {
		visitsCache.updateVisit(visit);
		modelMap.addAttribute("visit", visit);
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/deleteVisit", method = RequestMethod.DELETE)
	public String deleteVisit(ModelMap modelMap, Visit visit) {
		visitsCache.deleteVisit(visit);
		modelMap.addAttribute("visit", visit);
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/addTestVisits", method = RequestMethod.GET)
	public String addTestVisits(ModelMap modelMap) {
		Visit visit;
		Visitor visitor;
		int numberOfTestVisits = 10;
		for (Integer i = 1; i <= numberOfTestVisits; i++) {			
			visit = new Visit();
			visitor = new Visitor();
			
			visitor.setId(i);
			visitor.setFirstName("first_name_" + i);
			visitor.setLastName("last_name_" + i);
			visitor.setFrom("from_" + i);
			
			visit.setId(i);
			visit.setVisitor(visitor);
			if (i == 3 || i == 6) {
				visit.setCompany(Company.COMPANY_A);
			} else if (i % 2 == 0) {
				visit.setCompany(Company.COMPANY_B);
			} else {
				visit.setCompany(Company.COMPANY_C);
			}
			visit.setVisitReason("visit_reason_" + i);
			visit.setTimeIn(new DateTime(2015, 1, 1, 12, i));
			visit.setTimeOut(new DateTime(2015, 1, 1, 12, i+10));
		}
		return "viewVisitors";
	}
	
	private String redirect(String page) {
		return "redirect:/" + page;
	}
	

}

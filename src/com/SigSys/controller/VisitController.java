package com.SigSys.controller;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SigSys.cache.VisitorsCache;
import com.SigSys.cache.VisitsCache;
import com.SigSys.form.NewVisitForm;
import com.SigSys.model.Company;
import com.SigSys.model.Visit;
import com.SigSys.model.Visitor;

@RequestMapping("/visit")
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
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("newVisitForm", new NewVisitForm());
		return "newVisit";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(ModelMap modelMap, @ModelAttribute("newVisitForm") NewVisitForm newVisitForm) {
		Visit newVisit = newVisitForm.getVisit();
		Visitor newVisitor = newVisitForm.getVisitor();
		
		DateTime currentDateTime = new DateTime();
		newVisit.setTimeIn(currentDateTime);
		newVisit.setVisitor(newVisitor);
		
		visitsCache.addVisit(newVisit);
		
		if (!visitorsCache.contains(newVisitor)) {
			visitorsCache.addVisitor(newVisitor);
		}
		
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/addTest", method = RequestMethod.GET)
	public String addTest(ModelMap modelMap) {
		final int numberOfTestVisits = 10;
		Visit visit;
		Visitor visitor;
		for (int i = 1; i <= numberOfTestVisits; i++) {
			visit = new Visit();
			visitor = new Visitor();
			visitor.setId(i);
			
			visitor.setFirstName("firstName_" + i);
			visitor.setLastName("lastName_" + i);
			visitorsCache.addVisitor(visitor);
			
			visit.setId(i);
			visit.setVisitor(visitor);
			visit.setTimeIn(new DateTime());
			visitsCache.addVisit(visit);
		}
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/end/{visitId}", method = RequestMethod.GET)
	public String end(ModelMap modelMap, @PathVariable Integer visitId) {
		Visit visit = visitsCache.getVisit(visitId);
		if (visit != null) {
			visit.setTimeOut(new DateTime());
			visitsCache.updateVisit(visit);
		}
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(ModelMap modelMap) {
		
		return redirect("");
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public String filter(ModelMap modelMap) {
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(ModelMap modelMap, Visit visit) {
		visitsCache.updateVisit(visit);
		modelMap.addAttribute("visit", visit);
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/view/{visitId}", method = RequestMethod.GET)
	public String view(ModelMap modelMap, @PathVariable Integer visitId) {
		Visit visit = visitsCache.getVisit(visitId);
		modelMap.addAttribute("visit", visit);
		return "viewVisit";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String delete(ModelMap modelMap, Visit visit) {
		visitsCache.deleteVisit(visit);
		modelMap.addAttribute("visit", visit);
		return redirect("homepage");
	}
	
	private String redirect(String page) {
		return "redirect:/" + page;
	}
	

}

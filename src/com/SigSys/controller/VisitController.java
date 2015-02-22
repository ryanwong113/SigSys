package com.SigSys.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

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
	
	@RequestMapping(value = "/addTestVisit", method = RequestMethod.GET)
	public String addTestVisit(ModelMap modelMap) {
		modelMap.addAttribute("testVisitForm", new TestVisitForm());
		return "newTestVisit";
	}
	
	@RequestMapping(value = "/addTestVisit", method = RequestMethod.POST)
	public String addTestVisit(ModelMap modelMap, @ModelAttribute("testVisitForm") TestVisitForm testVisitForm) {
		final int numberOfTestVisits = Integer.parseInt(testVisitForm.getNumberOfTestVisits());
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
	
	@RequestMapping(value = "/endVisit/{visitId}", method = RequestMethod.GET)
	public String endVisit(ModelMap modelMap, @PathParam("visitId") int visitId) {
		Visit visit = visitsCache.getVisit(visitId);
		visit.setTimeOut(new DateTime());
		visitsCache.updateVisit(visit);
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
	
	private String redirect(String page) {
		return "redirect:/" + page;
	}
	

}

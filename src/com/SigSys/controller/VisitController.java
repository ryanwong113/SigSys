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
import com.SigSys.form.FilterVisitsForm;
import com.SigSys.form.NewVisitForm;
import com.SigSys.model.Company;
import com.SigSys.model.Visit;
import com.SigSys.model.Visitor;
import com.SigSys.util.VisitsFilter;

@RequestMapping("/visit")
@Controller
public class VisitController {
	
	@Autowired
	VisitsCache visitsCache;
	
	@Autowired
	VisitorsCache visitorsCache;
	
	public List<Visit> getVisits() {
		List<Visit> visits = new ArrayList<Visit>();
		visits.addAll(visitsCache.getVisits().values());
		return visits;
	}
	
	@RequestMapping("")
	public String view(ModelMap modelMap) {
		if (!visitsCache.isEmpty()) {
			modelMap.addAttribute("isEmpty", "false");
		} else {
			modelMap.addAttribute("isEmpty", "true");
		}
		modelMap.addAttribute("newVisitForm", new NewVisitForm());
		modelMap.addAttribute("visits", getVisits());
		return "homepage";
	}
	
//	@RequestMapping(value = "/{visitId}", method = RequestMethod.GET)
//	public String view(ModelMap modelMap, @PathVariable Integer visitId) {
//		Visit visit = visitsCache.getVisit(visitId);
//		modelMap.addAttribute("visit", visit);
//		return "viewVisit";
//	}
	
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
			
			visitor.setFirstName("firstName_" + i);
			visitor.setLastName("lastName_" + i);
			visitorsCache.addVisitor(visitor);
			
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
		
		return "viewVisits";
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public String filter(ModelMap modelMap, @ModelAttribute("filterVisitsForm") FilterVisitsForm filterVisitsForm) {
		List<Visit> filteredVisits = visitsCache.getAllVisits();
		String firstName = filterVisitsForm.getFirstName();
		String lastName = filterVisitsForm.getLastName();
		List<Company> companies = filterVisitsForm.getCompanies();
		DateTime timeIn = filterVisitsForm.getTimeIn();
		DateTime timeOut = filterVisitsForm.getTimeOut();
		
		// Filter visits with companies
		if (companies != null) {
			filteredVisits = VisitsFilter.filterVisitsByCompanies(filteredVisits, companies);
		}
		
		// Filter visits with visitors' names
		if (!firstName.isEmpty() && !lastName.isEmpty()) {
			filteredVisits = VisitsFilter.filterVisitsByFullName(filteredVisits, firstName, lastName);
		} else if (!firstName.isEmpty() && lastName.isEmpty()) {
			filteredVisits = VisitsFilter.filterVisitsByFirstName(filteredVisits, firstName);
		} else if (firstName.isEmpty() && !lastName.isEmpty()) {
			filteredVisits = VisitsFilter.filterVisitsByLastName(filteredVisits, lastName);
		}
		
		if (timeIn != null) {
			filteredVisits = VisitsFilter.filterVisitsByTimeInBefore(filteredVisits, timeIn);
		}
		if (timeOut != null) {
			filteredVisits = VisitsFilter.filterVisitsByTimeOutBefore(filteredVisits, timeOut);
		}
		modelMap.addAttribute("visits", filteredVisits);
		return "viewVisits";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(ModelMap modelMap, Visit visit) {
		visitsCache.updateVisit(visit);
		modelMap.addAttribute("visit", visit);
		return redirect("homepage");
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

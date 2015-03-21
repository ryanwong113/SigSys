package com.SigSys.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SigSys.cache.VisitorsCache;
import com.SigSys.form.FilterVisitorsForm;
import com.SigSys.model.Visitor;

@RequestMapping("/visitor")
@Controller
public class VisitorController {

	@Autowired
	VisitorsCache visitorsCache;
	
	@ModelAttribute("visitors")
	public List<Visitor> getVisitors() {
		List<Visitor> visitors = new ArrayList<Visitor>();
		visitors.addAll(visitorsCache.getVisitors().values());
		return visitors;
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String view(ModelMap modelMap) {
		if (!visitorsCache.isEmpty()) {
			modelMap.addAttribute("isEmpty", "false");
		} else {
			modelMap.addAttribute("isEmpty", "true");
		}
		return "viewVisitors";
	}
	
	@RequestMapping(value = "/{visitorId}", method = RequestMethod.GET)
	public String view(ModelMap modelMap, @PathVariable Integer visitorId) {
		Visitor visitor = visitorsCache.getVisitorById(visitorId);
		modelMap.addAttribute("visitor", visitor);
		return "viewVisitor";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("newVisitor", new Visitor());
		return "newVisitor";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(ModelMap modelMap, @ModelAttribute("newVisitor") Visitor newVisitor) {
		visitorsCache.addVisitor(newVisitor);
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public String filter(ModelMap modelMap, 
						RedirectAttributes redirectAttributes,
						@ModelAttribute("filterVisitorsForm") FilterVisitorsForm filterVisitorsForm) {
		String firstName = filterVisitorsForm.getFirstName();
		String lastName = filterVisitorsForm.getLastName();
		List<Visitor> filteredVisitors;
		
		if (firstName.isEmpty() && lastName.isEmpty()) {
			filteredVisitors = visitorsCache.getAllVisitors();
		} else if (!firstName.isEmpty() && lastName.isEmpty()) {
			filteredVisitors = visitorsCache.getVisitorsByFirstName(firstName);
		} else if (firstName.isEmpty() && !lastName.isEmpty()) {
			filteredVisitors = visitorsCache.getVisitorsByLastName(lastName);
		} else {
			filteredVisitors = visitorsCache.getVisitorsByFullName(firstName, lastName);
		}
		redirectAttributes.addFlashAttribute("visitors", filteredVisitors);
		return redirect("visitor");
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String update(ModelMap modelMap, Visitor visitor) {
		visitorsCache.updateVisitor(visitor);
		modelMap.addAttribute("visitor", visitor);
		return redirect("visitor");
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteVisitor(ModelMap modelMap, Visitor visitor) {
		visitorsCache.deleteVisitor(visitor);
		modelMap.addAttribute("visitor", visitor);
		return redirect("homepage");
	}
		
	private String redirect(String page) {
		return "redirect:/" + page;
	}
	
}

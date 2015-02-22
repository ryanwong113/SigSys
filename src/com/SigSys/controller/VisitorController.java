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
import com.SigSys.model.Visitor;

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
	
	@RequestMapping(value = "viewVisitors", method = RequestMethod.GET)
	public String viewVisitors(ModelMap modelMap) {
		if (!visitorsCache.isEmpty()) {
			modelMap.addAttribute("isEmpty", "false");
		} else {
			modelMap.addAttribute("isEmpty", "true");
		}
		return "viewVisitors";
	}
	
	@RequestMapping(value = "addVisitor", method = RequestMethod.GET)
	public String addVisitor(ModelMap modelMap) {
		modelMap.addAttribute("newVisitor", new Visitor());
		return "newVisitor";
	}
	
	@RequestMapping(value = "addVisitor", method = RequestMethod.POST)
	public String addVisitor(ModelMap modelMap, @ModelAttribute("newVisitor") Visitor newVisitor) {
		visitorsCache.addVisitor(newVisitor);
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/updateVisitor", method = RequestMethod.PUT)
	public String updateVisitor(ModelMap modelMap, Visitor visitor) {
		visitorsCache.updateVisitor(visitor);
		modelMap.addAttribute("visitor", visitor);
		return redirect("homepage");
	}
	
	@RequestMapping(value = "/deleteVisitor", method = RequestMethod.DELETE)
	public String deleteVisitor(ModelMap modelMap, Visitor visitor) {
		visitorsCache.deleteVisitor(visitor);
		modelMap.addAttribute("visitor", visitor);
		return redirect("homepage");
	}
	
//	// Show visitors with query surname
//	@RequestMapping(value = "/visit", method = RequestMethod.GET)
//	public 
//	
//	
//	// Show visitors with query from (where they come from)
//	@RequestMapping(value = "/visit", method = RequestMethod.GET)
//	public 
	
	private String redirect(String page) {
		return "redirect:/" + page;
	}
	
}

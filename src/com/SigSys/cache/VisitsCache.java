package com.SigSys.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.SigSys.model.Company;
import com.SigSys.model.Visit;
import com.SigSys.model.Visitor;

@Service
public class VisitsCache {

	private Integer currentId = 1;
	
	// Cache for storing visits
	private Map<Integer, Visit> visitsById;
		
	@PostConstruct
	public void init() {
		refresh();
	}
	
	public void refresh() {
		visitsById = new HashMap<Integer, Visit>();
	}
	
	public Map<Integer, Visit> getVisits() {
		return visitsById;
	}
	
	public boolean isEmpty() {
		return visitsById.isEmpty();
	}
	
	public void addVisit(final Visit visit) {
		visit.setId(currentId);
		visitsById.put(currentId, visit);
		currentId++;
	}
		
	public void updateVisit(Visit visit) {
		if (!visitsById.containsValue(visit)) {
			
		}
		visitsById.put(visit.getId(), visit);
	}
	
	public void deleteVisit(Visit visit) {
		if (!visitsById.containsValue(visit)) {
			
		}
		visitsById.remove(visit.getId());
	}
	
	public Visit getVisit(final Integer id) {
		Visit visit = null;
		if (visitsById.containsKey(id)) {
			visit = visitsById.get(id);
		}
		return visit;
	}
	
	public List<Visit> getAllVisits() {
		List<Visit> visits = new ArrayList<Visit>();
		visits.addAll(visitsById.values());
		return visits;
	}
	
	public List<Visit> getVisitsByFirstName(final String firstName) {
		List<Visit> visits = new ArrayList<Visit>();
		visits.addAll(visitsById.values());
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visitor visitor = it.next().getVisitor();
			if (!visitor.getFirstName().equals(firstName)) {
				it.remove();
			}
		}
		return visits;
	}
	
	public List<Visit> getVisitsByLastName(final String lastName) {
		List<Visit> visits = new ArrayList<Visit>();
		visits.addAll(visitsById.values());
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visitor visitor = it.next().getVisitor();
			if (!visitor.getLastName().equals(lastName)) {
				it.remove();
			}
		}
		return visits;
	}
	
	public List<Visit> getVisitsByFullName(final String firstName, final String lastName) {
		List<Visit> visits = new ArrayList<Visit>();
		visits.addAll(visitsById.values());
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visitor visitor = it.next().getVisitor();
			if (!(visitor.getFirstName().equals(firstName) && visitor.getLastName().equals(lastName))) {
				it.remove();
			}
		}
		return visits;
	}
	
	public List<Visit> getVisitsByCompany(final Company company) {
		List<Visit> visits = new ArrayList<Visit>();
		visits.addAll(visitsById.values());
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (visit.getCompany() != company) {
				it.remove();
			}
		}
		return visits;
	}
	
	public List<Visit> getVisitsBeforeTime(final DateTime date) {
		List<Visit> visits = new ArrayList<Visit>();
		visits.addAll(visitsById.values());
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (visit.getTimeIn().isAfter(date.getMillis())) {
				it.remove();
			}
		}
		return visits;
	}
	
	public List<Visit> getVisitsAfterTime(final DateTime date) {
		List<Visit> visits = new ArrayList<Visit>();
		visits.addAll(visitsById.values());
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (visit.getTimeIn().isBefore(date.getMillis())) {
				it.remove();
			}
		}
		return visits;
	}
	
}

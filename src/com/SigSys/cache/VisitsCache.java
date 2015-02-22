package com.SigSys.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.SigSys.model.Company;
import com.SigSys.model.Visit;

@Service
public class VisitsCache {

	private int currentId = 1;
	
	// Cache for storing visits
	private Map<Integer, Visit> visits;
		
	@PostConstruct
	public void init() {
		refresh();
	}
	
	public void refresh() {
		visits = new HashMap<Integer, Visit>();
	}
	
	public Map<Integer, Visit> getVisits() {
		return visits;
	}
	
	public boolean isEmpty() {
		return visits.isEmpty();
	}
	
	public void addVisit(final Visit visit) {
		visit.setId(currentId);
		visits.put(currentId, visit);
		currentId++;
	}
		
	public void updateVisit(Visit visit) {
		if (!visits.containsValue(visit)) {
			
		}
		visits.put(visit.getId(), visit);
	}
	
	public void deleteVisit(Visit visit) {
		if (!visits.containsValue(visit)) {
			
		}
		visits.remove(visit.getId());
	}
	
	public Visit getVisit(final int id) {
		Visit visit = null;
		if (visits.containsKey(id)) {
			visit = visits.get(id);
		}
		return visit;
	}
	
	public List<Visit> getVisitsByCompany(final Company company) {
		List<Visit> visits = (List<Visit>) this.visits.values();
		Iterator<Visit> it = visits.iterator();
		while (it.hasNext()) {
			Visit visit = it.next();
			if (visit.getCompany() != company) {
				it.remove();
			}
		}
		return visits;
	}
	
	
}

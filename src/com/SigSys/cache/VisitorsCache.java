package com.SigSys.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.SigSys.model.Visitor;

@Service
public class VisitorsCache {
	
	private int currentId = 1;
	
	// Storing visitors by id
	private Map<Integer, Visitor> visitorsById;
	
	@PostConstruct
	public void init() {
		refresh();
	}
	
	public void refresh() {
		visitorsById = new HashMap<Integer, Visitor>();
	}
	
	public Map<Integer, Visitor> getVisitors() {
		return visitorsById;
	}
	
	public List<Visitor> getAllVisitors() {
		List<Visitor> visitors = new ArrayList<Visitor>();
		visitors.addAll(visitorsById.values());
		return visitors;
	}
	
	public boolean isEmpty() {
		return visitorsById.isEmpty();
	}
	
	public void addVisitor(Visitor visitor) {
		visitor.setId(currentId);
		visitorsById.put(currentId, visitor);
		currentId++;
	}
	
	public void updateVisitor(Visitor visitor) {
		if (!visitorsById.containsValue(visitor)) {
			
		}
		visitorsById.put(visitor.getId(), visitor);
	}
	
	public void deleteVisitor(Visitor visitor) {
		if (!visitorsById.containsValue(visitor)) {
			
		}
		visitorsById.remove(visitor.getId());
	}
	
	public Visitor getVisitorById(int id) {
		return visitorsById.get(id);
	}
	
	public boolean contains(Visitor visitor) {
		return visitorsById.containsValue(visitor);
	}
	
	public List<Visitor> getVisitorsByFirstName(String firstName) {
		List<Visitor> visitors = new ArrayList<Visitor>();
		visitors.addAll(visitorsById.values());
		Iterator<Visitor> it = visitors.iterator();
		while (it.hasNext()) {
			Visitor visitor = it.next();
			if (!firstName.equals(visitor.getFirstName())) {
				it.remove();
			}
		}
		return visitors;
	}
	
	public List<Visitor> getVisitorsByLastName(String lastName) {
		List<Visitor> visitors = new ArrayList<Visitor>();
		visitors.addAll(visitorsById.values());
		Iterator<Visitor> it = visitors.iterator();
		while (it.hasNext()) {
			Visitor visitor = it.next();
			if (!lastName.equals(visitor.getLastName())) {
				it.remove();
			}
		}
		return visitors;
	}
	
	public List<Visitor> getVisitorsByFullName(String firstName, String lastName) {
		List<Visitor> visitors = new ArrayList<Visitor>();
		visitors.addAll(visitorsById.values());
		Iterator<Visitor> it = visitors.iterator();
		while (it.hasNext()) {
			Visitor visitor = it.next();
			if (!(firstName.equals(visitor.getFirstName()) && lastName.equals(visitor.getLastName()))) {
				it.remove();
			}
		}
		return visitors;
	}
	
	public List<Visitor> getVisitorsByFrom(String from) {
		List<Visitor> visitors = (List<Visitor>) visitorsById.values();
		Iterator<Visitor> it = visitors.iterator();
		while (it.hasNext()) {
			Visitor visitor = it.next();
			if (!from.equals(visitor.getFrom())) {
				it.remove();
			}
		}
		return visitors;
	}
	
}

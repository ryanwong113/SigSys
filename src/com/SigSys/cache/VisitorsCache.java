package com.SigSys.cache;

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
	
	// Cache for storing visitors
	private Map<Integer, Visitor> visitors;
	
	@PostConstruct
	public void init() {
		refresh();
	}
	
	public void refresh() {
		visitors = new HashMap<Integer, Visitor>();
	}
	
	public Map<Integer, Visitor> getVisitors() {
		return visitors;
	}
	
	public boolean isEmpty() {
		return visitors.isEmpty();
	}
	
	public void addVisitor(Visitor visitor) {
		visitor.setId(currentId);
		visitors.put(currentId, visitor);
		currentId++;
	}
	
	public void updateVisitor(Visitor visitor) {
		if (!visitors.containsValue(visitor)) {
			
		}
		visitors.put(visitor.getId(), visitor);
	}
	
	public void deleteVisitor(Visitor visitor) {
		if (!visitors.containsValue(visitor)) {
			
		}
		visitors.remove(visitor.getId());
	}
	
	public Visitor getVisitorById(int id) {
		return visitors.get(id);
	}
	
	public boolean contains(Visitor visitor) {
		return visitors.containsValue(visitor);
	}
	
	public List<Visitor> getVisitorsByLastName(String lastName) {
		List<Visitor> visitors = (List<Visitor>) this.visitors.values();
		Iterator<Visitor> it = visitors.iterator();
		while (it.hasNext()) {
			Visitor visitor = it.next();
			if (!lastName.equals(visitor.getLastName())) {
				it.remove();
			}
		}
		return visitors;
	}
	
	public List<Visitor> getVisitorsByFrom(String from) {
		List<Visitor> visitors = (List<Visitor>) this.visitors.values();
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

package com.SigSys.model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Group {

	private static AtomicInteger nextId = new AtomicInteger();
	
	private final int id;
	private String name;
	private List<Visitor> visitors;
	
	public Group() {
		id = nextId.incrementAndGet();
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Visitor> getVisitors() {
		return visitors;
	}
	
	public void setVisitors(List<Visitor> visitors) {
		this.visitors = visitors;
	}
	
	public void addVisitor(Visitor visitor) {
		visitors.add(visitor);
	}
}

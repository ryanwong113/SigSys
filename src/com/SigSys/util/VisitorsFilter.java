package com.SigSys.util;

import java.util.Iterator;
import java.util.List;

import com.SigSys.model.Visitor;

public class VisitorsFilter {
	
	public static List<Visitor> filterVisitorsByFirstName(List<Visitor> visitors, final String firstName) {
		Iterator<Visitor> it = visitors.iterator();
		while (it.hasNext()) {
			Visitor visitor = it.next();
			if (!firstName.equals(visitor.getFirstName())) {
				it.remove();
			}
		}
		return visitors;
	}
	
	public static List<Visitor> filterVisitorsByLastName(List<Visitor> visitors, final String lastName) {
		Iterator<Visitor> it = visitors.iterator();
		while (it.hasNext()) {
			Visitor visitor = it.next();
			if (!lastName.equals(visitor.getLastName())) {
				it.remove();
			}
		}
		return visitors;
	}

}

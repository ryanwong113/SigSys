package com.SigSys.form;

import com.SigSys.model.Visit;
import com.SigSys.model.Visitor;

public class NewVisitForm {
	
	private Visit visit;
	private Visitor visitor;
	
	public NewVisitForm() {
		visit = new Visit();
		visitor = new Visitor();
	}
	
	public Visit getVisit() {
		return visit;
	}
	
	public void setVisit(Visit visit) {
		this.visit = visit;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}
	
}

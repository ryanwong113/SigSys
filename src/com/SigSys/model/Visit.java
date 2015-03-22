package com.SigSys.model;

import org.joda.time.DateTime;

public class Visit {
				
	private int id;
	private Visitor visitor;
	private Company company;
	private String visitReason;
	private DateTime timeIn;
	private DateTime timeOut;
	
	public Visit() {
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public Visitor getVisitor() {
		return visitor;
	}
	
	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Company getCompany() {
		return company;
	}
	
	public void setCompany(Company company) {
		this.company = company;
	}
	
	public String getVisitReason() {
		return visitReason;
	}
	
	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
	}
	
	public DateTime getTimeIn() {
		return timeIn;
	}
	
	public void setTimeIn(DateTime timeIn) {
		this.timeIn = timeIn;
	}

	public DateTime getTimeOut() {
		return timeOut;
	}
	
	public void setTimeOut(DateTime timeOut) {
		this.timeOut = timeOut;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Visit)) return false;
		Visit v1 = (Visit) o;
		if (!this.visitor.equals(v1.visitor)) return false;
		if (!this.company.equals(v1.company)) return false;
		if (!this.timeIn.equals(v1.timeIn)) return false;
		if (!this.timeOut.equals(v1.timeOut)) return false;
		if (!this.visitReason.equals(v1.visitReason)) return false;
		return true;
	}
}
